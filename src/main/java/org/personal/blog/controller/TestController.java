package org.personal.blog.controller;

import org.personal.blog.mapper.*;
import org.personal.blog.pojo.entity.BlogPermission;
import org.personal.blog.pojo.entity.BlogRolePermission;
import org.personal.blog.pojo.runable.RunableRolePermission;
import org.personal.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by zs on 2019/10/25
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    BlogUserMapper userMapper;
    @Autowired
    BlogRoleMapper roleMapper;
    @Autowired
    BlogPermissionMapper permissionMapper;
    @Autowired
    BlogUserRoleMapper userRoleMapper;
    @Autowired
    BlogRolePermissionMapper rolePermissionMapper;

    @RequestMapping("/test4")
    public Object test4()throws Exception{
        long startTime=System.currentTimeMillis();   //获取开始时间
        int count = 1;
        LinkedBlockingQueue<Runnable> workingQueue = new LinkedBlockingQueue<Runnable>();
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardPolicy();
        //获取线程池
        ExecutorService pool = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,workingQueue,rejectedExecutionHandler);
        for(int i = 0;i<30000;i++){
            RunableRolePermission runable = new RunableRolePermission(rolePermissionMapper,count);
            pool.execute(runable);
            count += 100;
        }
        pool.shutdown();
        pool.awaitTermination(1,TimeUnit.HOURS);//等待所有线程执行完成
        //插入500万数据
        /*for(int i = 0;i<1000;i++){
            List<BlogUser> users = new ArrayList<>();
            for(int j=0;j<1000;j++){
                BlogUser user = new BlogUser();
                user.setUserName(NumberTools.get32UUID());
                user.setPhone("15130324819");
                user.setEmail("1799240625@qq.com");
                user.setCreateTime(new Date());
                users.add(user);
            }
            int count1 = userMapper.insertBatch(users);
            count += count1;
        }*/
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        Map<String, Object> resMap = new HashMap<>();
        long ti = endTime-startTime;
        float cous = (float) (ti/1000.0);
        resMap.put("count",count);
        resMap.put("time",cous+"秒");
        return ResultUtil.success(resMap);
    }

    @RequestMapping("/test5")
    public Object test5(){
        long startTime=System.currentTimeMillis();   //获取开始时间
        int userId = 1456897;
        BlogRolePermission blogRolePermission = rolePermissionMapper.selectByPrimaryKey(userId);
        Integer permissionId = blogRolePermission.getPermissionId();
        BlogPermission blogPermission = permissionMapper.selectByPrimaryKey(permissionId);
        long endTime=System.currentTimeMillis(); //获取结束时间
        long ti = endTime-startTime;
        System.out.println("程序运行时间： "+ti+"ms");
        float cous = (float) (ti/1000.0);
        return ResultUtil.success(200,cous+"秒",blogPermission);
    }
    @RequestMapping("/test6")
    public Object test6(){
        long startTime=System.currentTimeMillis();   //获取开始时间
        int userId = 1456897;
        BlogRolePermission blogRolePermission = rolePermissionMapper.selectByPrimaryKey(userId);
        Integer permissionId = blogRolePermission.getPermissionId();
        BlogPermission blogPermission = permissionMapper.selectByPrimaryKey(permissionId);
        long endTime=System.currentTimeMillis(); //获取结束时间
        long ti = endTime-startTime;
        System.out.println("程序运行时间： "+ti+"ms");
        float cous = (float) (ti/1000.0);
        return ResultUtil.success(200,cous+"秒",blogPermission);
    }
}
