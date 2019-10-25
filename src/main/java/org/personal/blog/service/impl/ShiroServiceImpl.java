package org.personal.blog.service.impl;

import org.personal.blog.bean.BlogUser;
import org.personal.blog.bean.BlogUserRole;
import org.personal.blog.mapper.BlogRoleMapper;
import org.personal.blog.mapper.BlogRolePermissionMapper;
import org.personal.blog.mapper.BlogUserMapper;
import org.personal.blog.mapper.BlogUserRoleMapper;
import org.personal.blog.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zs on 2019/7/29
 * shiro相关服务
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private BlogUserRoleMapper userRoleMapper;
    @Autowired
    private BlogRoleMapper roleMapper;
    @Autowired
    private BlogRolePermissionMapper rolePermissionMapper;
    @Autowired
    private BlogUserMapper userMapper;

    /**
     * @author zs
     * @date 2019/7/29 19:06
     * 根据uuid获取角色名称的集合
     **/
    @Override
    public List<String> getRolesByUuid(int uuid) {
        String[] roleIds = getRoleIdsByUserId(uuid);
        return roleMapper.getRoleNamesByRoleId(roleIds);
    }

    /**
     * @author zs
     * @date 2019/7/30 9:23
     * 根据用户id查询相应权限路径集合
     **/
    @Override
    public List<String> getPermissionUrlByUserId(int userId) {
        String[] roleIds = getRoleIdsByUserId(userId);
        //根据role查询所有不重复的权限id
        return rolePermissionMapper.getPermissionUrlByRoleIds(roleIds);
    }

    /**
     * @author zs
     * @date 2019/7/30 9:56
     * 根据userId查询用户
     **/
    @Override
    public BlogUser getUserByUserName(String userName) {
        BlogUser user  = new BlogUser();
        user.setUserName(userName);
        user.setIsDelete(false);
        return userMapper.selectOne(user);
    }

    /**
     * @author zs
     * @date 2019/7/30 9:25
     * 根据用户id获取角色id
     **/
    public String[] getRoleIdsByUserId(int userId){
        BlogUserRole userRole = new BlogUserRole();
        userRole.setUserId(userId);
        List<BlogUserRole> userRoles = userRoleMapper.select(userRole);
        String roleIds = "";
        for(BlogUserRole uR : userRoles){
            roleIds += uR.getRoleId() +",";
        }
        String[] split = roleIds.split(",");
        return split;
    }
}
