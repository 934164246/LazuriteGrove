package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.dto.UserMomentDto;
import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.entity.UserEntity;
import com.rurigokou.front.service.ArticleService;
import com.rurigokou.front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.UserMomentDao;
import com.rurigokou.front.entity.UserMomentEntity;
import com.rurigokou.front.service.UserMomentService;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Service("userMomentService")
public class UserMomentServiceImpl extends ServiceImpl<UserMomentDao, UserMomentEntity> implements UserMomentService {

    @Autowired
    private UserMomentDao userMomentDao;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "articleService")
    private ArticleService articleService;

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

    @Override
    public List<UserMomentDto> page(Integer userId) {
        List<UserMomentEntity> userMoment = userMomentDao.selectMoment(userId);
        QueryWrapper<UserMomentEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        userMoment.addAll(this.list(wrapper));


        List<ArticleEntity> article = userMomentDao.getArticle(userId);
        QueryWrapper<ArticleEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        article.addAll(articleService.list(queryWrapper));


        List<UserMomentDto> list=new ArrayList<>();

        for (UserMomentEntity entity : userMoment) {
            UserMomentDto dto=new UserMomentDto();

            UserEntity user = userService.getById(entity.getUserId());

            dto.setId(entity.getUid());
            dto.setImg(entity.getImg());
            dto.setUserId(user.getId());
            dto.setHeadImg(user.getHeadImg());
            dto.setNickname(user.getNickname());
            dto.setDate(entity.getReleaseTime());
            dto.setContent(entity.getContent());
            dto.setType(2);

            list.add(dto);
        }

        for (ArticleEntity entity : article) {
            UserMomentDto dto=new UserMomentDto();

            UserEntity user = userService.getById(entity.getUserId());
            dto.setId(entity.getUid());
            dto.setImg(entity.getCoverImg());
            dto.setUserId(user.getId());
            dto.setHeadImg(user.getHeadImg());
            dto.setNickname(user.getNickname());
            dto.setDate(entity.getReleaseTime());
            dto.setContent(entity.getTitle());
            dto.setType(1);

            list.add(dto);
        }


        list.sort(Comparator.comparing(UserMomentDto::getDate).reversed());

        return list;
    }

}