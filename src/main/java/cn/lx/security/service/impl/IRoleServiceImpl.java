package cn.lx.security.service.impl;

import cn.lx.security.dao.RoleMapper;
import cn.lx.security.doamin.SysRole;
import cn.lx.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * cn.lx.security.service
 *
 * @Author Administrator
 * @date 12:16
 */
@Service
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void save(SysRole role) {
        roleMapper.save(role);
    }

    @Override
    public List<SysRole> findAll() {
        return roleMapper.findAll();
    }
}
