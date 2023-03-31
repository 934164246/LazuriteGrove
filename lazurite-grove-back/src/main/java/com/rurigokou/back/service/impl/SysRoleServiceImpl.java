package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.SysRoleDao;
import com.rurigokou.back.entity.SysRoleEntity;
import com.rurigokou.back.service.SysRoleService;

/**
* @author gokoururi
*/
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}