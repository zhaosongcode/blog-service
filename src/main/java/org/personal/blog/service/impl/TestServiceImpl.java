package org.personal.blog.service.impl;

import org.personal.blog.bean.BlogUser;
import org.personal.blog.mapper.BlogUserMapper;
import org.personal.blog.service.TestService;
import org.personal.blog.util.redis.RedisTools;
import org.personal.blog.util.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zs on 2019/8/1
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private BlogUserMapper userMapper;
    @Resource
    private RedisTools redisTools;

    private Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public Object saveTest(Integer par1, Integer par2) {
        redisTools.set("ceshi","测试啊");
        return ResultUtil.success();
    }

    @Override
    public Object testController() {
        BlogUser user = new BlogUser();
        user.setUserName("aaa");
        userMapper.insert(user);
        return ResultUtil.success();
    }

    @Override
    @Async("asyncPromiseExecutor")
    public Object testThread() {
        System.out.println("1");
        try {
            log.info("线程开始等待");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("等待结束");
        System.out.println("2");
        return null;
    }

    @Override
    //@Async("asyncPromiseExecutor")
    public void testThread2() {
        System.out.println("3");
        try {
            log.info("线程开始等待");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("等待结束");
        System.out.println("4");
    }
}
