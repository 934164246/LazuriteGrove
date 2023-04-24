package com.rurigokou.front.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.rurigokou.common.constant.JwtConstant;
import com.rurigokou.common.dto.JwtTokenDto;
import com.rurigokou.common.exception.RuriErrorCodeEnum;
import com.rurigokou.common.exception.RuriException;
import com.rurigokou.common.utils.JwtUtils;
import com.rurigokou.common.utils.RedisUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author gokoururi
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Resource(name = "redisUtils")
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");


        if (token == null) {
            throw new RuriException(RuriErrorCodeEnum.NO_TOKEN_EXCEPTION);
        }

        JwtTokenDto jwtTokenDto;
        try {
            jwtTokenDto = JwtUtils.parseToken(token);

        } catch (SignatureVerificationException exception) {
            throw new RuriException(RuriErrorCodeEnum.TOKEN_PAYLOAD_EXCEPTION);
        } catch (TokenExpiredException exception) {
            throw new RuriException(RuriErrorCodeEnum.TOKEN_EXPIRED_EXCEPTION);
        } catch (AlgorithmMismatchException exception) {
            throw new RuriException(RuriErrorCodeEnum.TOKEN_ALGORITHM_ERROR_EXCEPTION);
        } catch (Exception exception) {
            throw new RuriException(RuriErrorCodeEnum.TOKEN_FAILURE_EXCEPTION);
        }

        //根据uid在用户中查找是否存在此用户信息
        boolean exists = redisUtils.exists(String.valueOf(jwtTokenDto.getId()));

        //用户是否登录
        if(exists) {
            //token是否过期
            if (JwtUtils.isExpired(jwtTokenDto)) {
                JwtTokenDto dto=new JwtTokenDto();
                dto.setId(jwtTokenDto.getId());
                dto.setName(jwtTokenDto.getName());
                dto.setIat(new Date());
                dto.setExp(60L);

                response.setHeader(JwtConstant.NEW_TOKEN, JwtUtils.generateToken(dto));
            }

            return true;
        } else {
            throw new RuriException(RuriErrorCodeEnum.TOKEN_FAILURE_EXCEPTION);
        }
    }
}
