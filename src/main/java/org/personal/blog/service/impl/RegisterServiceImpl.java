package org.personal.blog.service.impl;

import org.personal.blog.bean.BlogUser;
import org.personal.blog.mapper.BlogUserMapper;
import org.personal.blog.service.RegisterService;
import org.personal.blog.util.result.ResultUtil;
import org.personal.blog.util.time.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by zs on 2019/9/21
 * 注册service
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private BlogUserMapper userMapper;

    /**
     * @Param [parMap]
     * @Return void
     * @Author zs
     * @Date 2019/9/21 10:34
     * 功能描述：注册
     */
    @Override
    public Object registerDo(Map<String, Object> parMap) {
        String userName = (String) parMap.get("userName");
        if(parMap == null || parMap.size()<1){
            return ResultUtil.error();
        }
        BlogUser user = new BlogUser();
        user.setUserName(userName);
        Date time = new Date();
        return null;
    }
}
