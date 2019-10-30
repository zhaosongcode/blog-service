package org.personal.blog.pojo.runable;

import org.personal.blog.mapper.BlogPermissionMapper;
import org.personal.blog.mapper.BlogRoleMapper;
import org.personal.blog.pojo.entity.BlogPermission;
import org.personal.blog.pojo.entity.BlogRole;
import org.personal.blog.util.NumberTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2019/10/29
 */
public class RunablePermission implements Runnable {

    private BlogPermissionMapper permissionMapper;
    int permissionId = 1;
    public RunablePermission(BlogPermissionMapper permissionMapper, int permissionId){
        this.permissionMapper = permissionMapper;
        this.permissionId = permissionId;
    }
    @Override
    public void run() {
        List<BlogPermission> users = new ArrayList<>();
        for(int j=0;j<100;j++){
            BlogPermission role = new BlogPermission();
            if(j != 0){
                role.setParentId(permissionId);
            }
            role.setPermissionName(NumberTools.get32UUID());
            role.setPermissionIcon(NumberTools.get32UUID());
            role.setPermissionUrl("test/test");
            role.setPermissionNote("测试数据");
            users.add(role);
        }
        permissionMapper.insertBatch(users);
    }
}
