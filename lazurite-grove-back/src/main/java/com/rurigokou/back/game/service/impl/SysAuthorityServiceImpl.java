package com.rurigokou.back.game.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.SysAuthorityDao;
import com.rurigokou.back.game.entity.SysAuthorityEntity;
import com.rurigokou.back.game.service.SysAuthorityService;

/**
* @author gokoururi
*/
@Service("sysAuthorityService")
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityDao, SysAuthorityEntity> implements SysAuthorityService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}