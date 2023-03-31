package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.SysAuthorityDao;
import com.rurigokou.back.entity.SysAuthorityEntity;
import com.rurigokou.back.service.SysAuthorityService;

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