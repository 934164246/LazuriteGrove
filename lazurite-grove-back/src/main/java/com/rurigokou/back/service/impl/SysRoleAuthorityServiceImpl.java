package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.SysRoleAuthorityDao;
import com.rurigokou.back.entity.SysRoleAuthorityEntity;
import com.rurigokou.back.service.SysRoleAuthorityService;

/**
* @author gokoururi
*/
@Service("sysRoleAuthorityService")
public class SysRoleAuthorityServiceImpl extends ServiceImpl<SysRoleAuthorityDao, SysRoleAuthorityEntity> implements SysRoleAuthorityService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}