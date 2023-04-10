package com.rurigokou.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.constant.SystemRedisConstant;
import com.rurigokou.back.pagination.GameTagPage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.pagination.RuriQuery;
import com.rurigokou.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.GameTagDao;
import com.rurigokou.back.entity.GameTagEntity;
import com.rurigokou.back.service.GameTagService;
import org.springframework.util.StringUtils;

/**
* @author gokoururi
*/
@Service("gameTagService")
public class GameTagServiceImpl extends ServiceImpl<GameTagDao, GameTagEntity> implements GameTagService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public RuriPage queryPage(GameTagPage page) {
        QueryWrapper<GameTagEntity> wrapper=new QueryWrapper<>();
        wrapper.eq(StringUtils.hasText(page.getId()),"id", page.getId())
                .like(StringUtils.hasText(page.getName()), "name", page.getName());


        return RuriPage.tranToPageVo(this.page(RuriQuery.getPage(page), wrapper));
    }

    @Override
    public Map<String, String> getAllTag() {
        Map<String, String> map;

        Object o = redisUtils.get(SystemRedisConstant.TAG);

        if (o == null || o instanceof Map) {
            List<GameTagEntity> list = this.list();

            map= list.stream()
                    .collect(Collectors.toMap(item -> String.valueOf(item.getId()), GameTagEntity::getName));
            redisUtils.set(SystemRedisConstant.TAG, map, 24*60L);
        } else {
            map= (Map<String, String>) o;
        }

        return map;
    }

}