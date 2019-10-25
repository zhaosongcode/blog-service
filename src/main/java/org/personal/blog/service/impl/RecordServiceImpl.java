package org.personal.blog.service.impl;

import org.personal.blog.bean.BlogRecordAccess;
import org.personal.blog.consts.record.RecordConsts;
import org.personal.blog.service.RecordService;
import org.personal.blog.util.common.Tools;
import org.personal.blog.util.redis.RedisTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zs on 2019/8/10
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RedisTools redisTools;

    /**
     * @Param [parMap]
     * @Return java.lang.Object
     * @Author zs
     * @Date 2019/8/10 9:30
     * 功能描述：保存访问记录
     */
    @Override
    public Object saveAccessToRecord(BlogRecordAccess blogRecordAccess) {
        blogRecordAccess.setCreateTime(new Date());
        blogRecordAccess.setSessionId((String) Tools.getSession().getId());
        //暂存入redis,待定时批量插入数据库
        List<BlogRecordAccess> accessToRecordsList = (List<BlogRecordAccess>) redisTools.get(RecordConsts.ACCESS_TO_RECORD);
        if(accessToRecordsList == null){
            accessToRecordsList = new ArrayList<>();
        }
        accessToRecordsList.add(blogRecordAccess);
        redisTools.set(RecordConsts.ACCESS_TO_RECORD,accessToRecordsList);
        return null;
    }
}
