package com.rurigokou.back.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rurigokou.back.game.dao.GameTypeDao;
import com.rurigokou.back.game.entity.GameTypeEntity;
import com.rurigokou.back.game.entity.TagGameRelationEntity;
import com.rurigokou.back.game.entity.TypeGameRelationEntity;
import com.rurigokou.back.game.pagination.GamePage;
import com.rurigokou.back.game.service.*;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.exception.RuriErrorCodeEnum;
import com.rurigokou.common.exception.RuriException;
import com.rurigokou.common.pagination.RuriQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.GameDao;
import com.rurigokou.back.game.entity.GameEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author gokoururi
*/
@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Resource(name = "gameTagService")
    private GameTagService gameTagService;

    @Resource(name = "gameTypeService")
    private GameTypeService gameTypeService;

    @Resource(name = "tagGameRelationService")
    private TagGameRelationService tagGameRelationService;

    @Resource(name = "typeGameRelationService")
    private TypeGameRelationService typeGameRelationService;

    @Autowired
    private GameTypeDao typeDao;

    @Override
    public RuriPage queryPage(GamePage gamePage) {
        String typeName = null;

        if (gamePage.getTypeId() != null) {
            GameTypeEntity gameTypeEntity = typeDao.selectById(gamePage.getTypeId());
            if (gameTypeEntity != null) {
                typeName = gameTypeEntity.getName();
            } else {
                return RuriPage.defaultPage(gamePage);
            }
        }

        QueryWrapper<GameEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.hasText(gamePage.getId()), "id", gamePage.getId())
                .eq(typeName != null, "type", typeName)
                .like(StringUtils.hasText(gamePage.getName()), "name", gamePage.getName());

        IPage<GameEntity> page = this.page(RuriQuery.getPage(gamePage), wrapper);

        return RuriPage.tranToPageVo(page);
    }


    @Override
    @Transactional(rollbackFor = {RuriException.class})
    public Object saveOrUpdateById(GameEntity entity) {
        //检测游戏名称是否重复
        if (StringUtils.hasText(entity.getName())) {
            QueryWrapper<GameEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("name", entity.getName());

            if (this.getOne(wrapper) != null) {
                throw new RuriException(RuriErrorCodeEnum.VALID_EXCEPTION);
            }
        }

        //判断是否为更新操作
        if (entity.getId() != null) {
            entity.setTag(null);
            entity.setType(null);

            this.updateById(entity);
        } else {
            if (!StringUtils.hasText(entity.getType()) || !StringUtils.hasText(entity.getTag())) {
                throw new RuriException(RuriErrorCodeEnum.VALID_EXCEPTION);
            }

            //处理type name
            String typeName = null;
            GameTypeEntity gameTypeEntity = gameTypeService.getOne(new QueryWrapper<GameTypeEntity>().eq("id", entity.getType()));

            if (gameTypeEntity != null) {
                typeName = gameTypeEntity.getName();
            }

            //看看是否有类型需要新增
            TypeGameRelationEntity typeGameRelationEntity=null;
            if (typeName == null) {
                typeGameRelationEntity = new TypeGameRelationEntity();
                typeGameRelationEntity.setTypeId(Integer.valueOf(entity.getType()));
            }
            entity.setType(typeName);

            //处理标签字段
            List<String> tagNames = new ArrayList<>();
            List<TagGameRelationEntity> tagGameRelationEntities = new ArrayList<>();
            String[] tagIds = entity.getTag().split(";");
            Map<String, String> allTag = gameTagService.getAllTag();
            for (String tagId : tagIds) {
                if (allTag.containsKey(tagId)) {
                    tagNames.add(allTag.get(tagId));

                    TagGameRelationEntity temp = new TagGameRelationEntity();
                    temp.setTagId(Integer.valueOf(tagId));
                    tagGameRelationEntities.add(temp);
                }
            }
            //判断是否有合适的数据
            if (!CollectionUtils.isEmpty(tagNames)) {
                entity.setTag(String.join(";", tagNames));
            } else {
                entity.setTag(null);
            }

            //保存game
            this.save(entity);

            //保存 type-game
            if (typeGameRelationEntity != null) {
                typeGameRelationEntity.setGameId(entity.getId());
                typeGameRelationService.save(typeGameRelationEntity);
            }

            //保存 tag-game
            if (!CollectionUtils.isEmpty(tagGameRelationEntities)) {
                for (TagGameRelationEntity relationEntity : tagGameRelationEntities) {
                    relationEntity.setGameId(entity.getId());
                }
                tagGameRelationService.saveBatch(tagGameRelationEntities);
            }

        }

        return true;
    }

}