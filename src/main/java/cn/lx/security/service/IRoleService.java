package cn.lx.security.service;

import cn.lx.security.doamin.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * cn.lx.security.service
 *
 * @Author Administrator
 * @date 12:16
 */
public interface IRoleService {


    public void save(SysRole role);

    public List<SysRole> findAll();
}
