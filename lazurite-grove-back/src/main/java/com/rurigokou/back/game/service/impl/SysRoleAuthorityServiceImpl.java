package com.rurigokou.back.game.service.impl;

import com.rurigokou.back.game.service.SysRoleAuthorityService;
import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.SysRoleAuthorityDao;
import com.rurigokou.back.game.entity.SysRoleAuthorityEntity;

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