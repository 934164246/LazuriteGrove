package com.rurigokou.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.entity.AnnouncementEntity;

import java.util.List;
import java.util.Map;

/**
 * 公告表
 *
 * @author gokoururi
 */
public interface AnnouncementService extends IService<AnnouncementEntity> {

    List<String> getTop();

    /**
     * 获取一些网站基本数据
     * @return {game, user, article}
     */
    Map<String, Long> getLocalData();
}

