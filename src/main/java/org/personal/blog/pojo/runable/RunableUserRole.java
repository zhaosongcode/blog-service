package org.personal.blog.pojo.runable;

import org.personal.blog.mapper.BlogPermissionMapper;
import org.personal.blog.mapper.BlogUserRoleMapper;
import org.personal.blog.pojo.entity.BlogPermission;
import org.personal.blog.pojo.entity.BlogUserRole;
import org.personal.blog.util.NumberTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2019/10/29
 */
public class RunableUserRole implements Runnable {

    private BlogUserRoleMapper userRoleMapper;
    int permissionId = 1;
    int temp = 0;
    public RunableUserRole(BlogUserRoleMapper permissionMapper, int permissionId){
        this.userRoleMapper = permissionMapper;
        this.permissionId = permissionId;
        this.temp = permissionId;
    }
    @Override
    public void run() {
        List<BlogUserRole> users = new ArrayList<>();
        for(int j=0;j<100;j++){
            BlogUserRole userRole = new BlogUserRole();
            userRole.setUserId(permissionId);
            userRole.setRoleId(NumberTools.getRanNum(temp,temp+100));
            users.add(userRole);
            permissionId++;
        }
        userRoleMapper.insertBatch(users);
    }
}
