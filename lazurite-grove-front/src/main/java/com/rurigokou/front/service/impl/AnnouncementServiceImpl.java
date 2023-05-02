package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.service.ArticleService;
import com.rurigokou.front.service.GameService;
import com.rurigokou.front.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.AnnouncementDao;
import com.rurigokou.front.entity.AnnouncementEntity;
import com.rurigokou.front.service.AnnouncementService;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Service("announcementService")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementDao, AnnouncementEntity> implements AnnouncementService {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "articleService")
    private ArticleService articleService;

    @Resource(name = "gameService")
    private GameService gameService;

    @Override
    public List<String> getTop() {
        QueryWrapper<AnnouncementEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("status", 1);

        List<AnnouncementEntity> list = this.list(wrapper);

        return list.stream()
                .map(AnnouncementEntity::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> getLocalData() {
        // TODO: 2023/4/25 给基本信息进行过滤，目前查询全部数据
        long user = userService.count();
        long game = gameService.count();
        long article = articleService.getNowCount();

        Map<String, Long> map=new HashMap<>(4);
        map.put("user", user);
        map.put("game", game);
        map.put("article", article);

        return map;
    }
}