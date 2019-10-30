package org.personal.blog.pojo.runable;

import org.personal.blog.mapper.BlogRolePermissionMapper;
import org.personal.blog.mapper.BlogUserRoleMapper;
import org.personal.blog.pojo.entity.BlogRolePermission;
import org.personal.blog.pojo.entity.BlogUserRole;
import org.personal.blog.util.NumberTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2019/10/29
 */
public class RunableRolePermission implements Runnable {

    private BlogRolePermissionMapper userRoleMapper;
    int permissionId = 1;
    int temp = 0;
    public RunableRolePermission(BlogRolePermissionMapper permissionMapper, int permissionId){
        this.userRoleMapper = permissionMapper;
        this.permissionId = permissionId;
        this.temp = permissionId;
    }
    @Override
    public void run() {
        List<BlogRolePermission> users = new ArrayList<>();
        for(int j=0;j<100;j++){
            BlogRolePermission userRole = new BlogRolePermission();
            userRole.setRoleId(permissionId);
            userRole.setPermissionId(NumberTools.getRanNum(temp,temp+100));
            users.add(userRole);
            permissionId++;
        }
        userRoleMapper.insertBatch(users);
    }
}
