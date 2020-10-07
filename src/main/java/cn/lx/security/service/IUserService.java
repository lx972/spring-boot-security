package cn.lx.security.service;

import cn.lx.security.doamin.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

/**
 * cn.lx.security.service
 *
 * @Author Administrator
 * @date 12:16
 */
public interface IUserService extends UserDetailsService {


    public void save(SysUser user);

    public List<SysUser> findAll();

    public Map<String, Object> toAddRolePage(Integer id);

    public void addRoleToUser(Integer userId, Integer[] ids);
}
