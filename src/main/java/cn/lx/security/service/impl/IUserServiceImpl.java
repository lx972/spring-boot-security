package cn.lx.security.service.impl;

import cn.lx.security.dao.UserMapper;
import cn.lx.security.doamin.SysRole;
import cn.lx.security.doamin.SysUser;
import cn.lx.security.service.IRoleService;
import cn.lx.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cn.lx.security.service.impl
 *
 * @Author Administrator
 * @date 12:17
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private IRoleService roleService;

    @Override
    public void save(SysUser user) {
        userMapper.save(user);
    }

    @Override
    public List<SysUser> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Map<String, Object> toAddRolePage(Integer id) {
        List<SysRole> allRoles = roleService.findAll();
        List<Integer> myRoles = userMapper.findRolesByUid(id);
        Map<String, Object> map = new HashMap();
        map.put("allRoles", allRoles);
        map.put("myRoles", myRoles);
        return map;
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        userMapper.removeRoles(userId);
        for (Integer rid : ids) {
            userMapper.addRoles(userId, rid);
        }
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userMapper.findByUsername(username);
        if (null==sysUser){
            throw new RuntimeException("没有此用户");
        }
        return sysUser;
    }
}
