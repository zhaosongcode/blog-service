package org.personal.blog.config.thread;

import org.personal.blog.mapper.BlogRoleMapper;
import org.personal.blog.mapper.BlogUserMapper;
import org.personal.blog.pojo.entity.BlogRole;
import org.personal.blog.pojo.entity.BlogUser;
import org.personal.blog.util.NumberTools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zs on 2019/10/29
 */
public class RunableRole implements Runnable {

    private BlogRoleMapper userMapper;
    private int count;
    public RunableRole(BlogRoleMapper userMapper, int count){
        this.userMapper = userMapper;
        this.count = count;
    }
    @Override
    public void run() {
        List<BlogRole> users = new ArrayList<>();
        for(int j=0;j<1000;j++){
            BlogRole role = new BlogRole();
            role.setRoleName(NumberTools.get32UUID());
            users.add(role);
        }
        int count1 = userMapper.insertBatch(users);
        count += count1;
    }
}
