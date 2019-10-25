package org.personal.blog.service.impl;

import org.personal.blog.bean.BlogRecordAccess;
import org.personal.blog.bean.BlogRecordLogin;
import org.personal.blog.mapper.BlogRecordAccessMapper;
import org.personal.blog.mapper.BlogRecordLoginMapper;
import org.personal.blog.service.SystemTimedTastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zs on 2019/8/10
 * 系统定时任务
 */
@Service
public class SystemTimedTastServiceImpl implements SystemTimedTastService {

    @Autowired
    private BlogRecordAccessMapper accessToRecordsMapper;

    @Autowired
    private BlogRecordLoginMapper loginMapper;

    /**
     * @Param [recordsList]
     * @Return void
     * @Author zs
     * @Date 2019/8/10 9:58
     * 功能描述：批量保存访问记录
     */
    @Override
    public void saveAccessToRecord(List<BlogRecordAccess> recordsList) {
        accessToRecordsMapper.insertList(recordsList);
    }

    /**
     * @Param [logins]
     * @Return void
     * @Author zs
     * @Date 2019/8/11 12:21
     * 功能描述：保存登录记录
     */
    @Override
    public void saveRecordLogin(List<BlogRecordLogin> logins) {
        loginMapper.insertList(logins);
    }
}
