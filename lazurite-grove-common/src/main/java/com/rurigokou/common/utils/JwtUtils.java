package com.rurigokou.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.rurigokou.common.constant.JwtConstant;
import com.rurigokou.common.dto.JwtTokenDto;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt认证信息
 *
 * @author gokoururi
 */
@Slf4j
public class JwtUtils {

    /**
     * 生成token字符串
     *
     * @param tokenDto payload信息
     * @return token
     */
    public static String generateToken(JwtTokenDto tokenDto) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtConstant.TOKEN_SECRET);

            Map<String, Object> header = new HashMap<>(4);
            header.put("typ", "JWT");
            header.put("alg", "HS256");


            LocalDateTime iat = LocalDateTime.now();
            LocalDateTime exp = iat.plusMinutes(tokenDto.getExp());

            return JWT.create()
                    .withHeader(header)
                    .withClaim(JwtConstant.ID, tokenDto.getId())
                    .withClaim(JwtConstant.USERNAME, tokenDto.getName())
                    .withIssuedAt(Date.from(iat.atZone(ZoneId.of("Asia/Shanghai")).toInstant()))
                    .withClaim(JwtConstant.TTL, tokenDto.getExp())
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析token
     *
     * @param token token
     * @return JwtTokenDto
     */
    public static JwtTokenDto parseToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(JwtConstant.TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT jwt = verifier.verify(token);
        int uid = jwt.getClaim(JwtConstant.ID).asInt();
        String name = jwt.getClaim(JwtConstant.USERNAME).asString();
        Date issuedAt = jwt.getIssuedAt();
        Long ttl = jwt.getClaim(JwtConstant.TTL).asLong();

        JwtTokenDto tokenDto = new JwtTokenDto();
        tokenDto.setId(uid);
        tokenDto.setName(name);
        tokenDto.setIat(issuedAt);
        tokenDto.setExp(ttl);

        return tokenDto;
    }

    /**
     * 检查是否过期
     *
     * @param dto dto
     * @return 过期为true，反之为false
     */
    public static boolean isExpired(JwtTokenDto dto) {
        Date iat = dto.getIat();
        long time = iat.getTime();
        long current = System.currentTimeMillis();

        return dto.getExp() * 60000 + time < current;
    }
}