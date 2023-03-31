package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.SysUserRoleDao;
import com.rurigokou.back.entity.SysUserRoleEntity;
import com.rurigokou.back.service.SysUserRoleService;

/**
* @author gokoururi
*/
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}