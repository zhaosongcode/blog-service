package org.personal.blog.service.impl;

import org.personal.blog.bean.BlogRecordLogin;
import org.personal.blog.bean.BlogUser;
import org.personal.blog.consts.record.RecordConsts;
import org.personal.blog.mapper.BlogUserMapper;
import org.personal.blog.service.LoginService;
import org.personal.blog.util.redis.RedisTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2019/8/1
 * 登录
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BlogUserMapper userMapper;

    @Autowired
    private RedisTools redisTools;
    /**
     * @Param [recordLogin]
     * @Return void
     * @Author zs
     * @Date 2019/8/11 12:12
     * 功能描述：将登陆信息存入redis集合，待定时存入数据库
     */
    @Override
    public void saveRecordLogin(BlogRecordLogin recordLogin) {
        List<BlogRecordLogin> loginRecords;
        loginRecords = (List<BlogRecordLogin>) redisTools.get(RecordConsts.LOGIN_RECORD);
        if(loginRecords == null){
            loginRecords = new ArrayList<>();
        }
        loginRecords.add(recordLogin);
        redisTools.set(RecordConsts.LOGIN_RECORD,loginRecords);
    }
    /**
     * @Param [userName]
     * @Return org.personal.blog.bean.BlogUser
     * @Author zs
     * @Date 2019/8/11 12:13
     * 功能描述：根据用户名获取用户
     */
    @Override
    public BlogUser getUser(String userName) {
        BlogUser user = new BlogUser();
        user.setUserName(userName);
        return userMapper.selectOne(user);
    }

    /**
     * @Param [email]
     * @Return org.personal.blog.bean.BlogUser
     * @Author zs
     * @Date 2019/8/14 16:38
     * 功能描述：根据邮箱获取用户
     */
    @Override
    public BlogUser getUserByEmail(String email) {
        BlogUser user = new BlogUser();
        user.setEmail(email);
        List<BlogUser> select = userMapper.select(user);
        if(select != null){
            return select.get(0);
        }
        return null;
    }
}
