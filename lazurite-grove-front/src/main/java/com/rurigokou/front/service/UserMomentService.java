package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.dto.UserMomentDto;
import com.rurigokou.front.entity.UserMomentEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户动态表
 *
 * @author gokoururi
 */
public interface UserMomentService extends IService<UserMomentEntity> {

    RuriPage queryPage(Map<String, Object> params);

    List<UserMomentDto> page(Integer userId);
}

