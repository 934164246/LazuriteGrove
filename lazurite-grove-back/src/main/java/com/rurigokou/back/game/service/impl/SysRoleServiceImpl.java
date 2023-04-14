package com.rurigokou.back.game.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.SysRoleDao;
import com.rurigokou.back.game.entity.SysRoleEntity;
import com.rurigokou.back.game.service.SysRoleService;

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