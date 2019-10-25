package org.personal.blog.timetask;

import org.personal.blog.bean.BlogRecordAccess;
import org.personal.blog.bean.BlogRecordLogin;
import org.personal.blog.consts.record.RecordConsts;
import org.personal.blog.properties.TomcatProperties;
import org.personal.blog.service.SystemTimedTastService;
import org.personal.blog.util.redis.RedisTools;
import org.personal.blog.util.time.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by zs on 2019/7/25
 * 系统相关定时任务
 */
@Component
public class SystemTimedTast {

    //日志保留数量
    @Autowired
    private TomcatProperties tomcatProperties;

    @Autowired
    private SystemTimedTastService timedTastService;

    @Autowired
    private RedisTools redisTools;

    /**
     * @author zs
     * @date 2019/7/25
     * 每日凌晨一点定时清理日志
     **/
    //@Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 0 1 * * ?")
    public void deleLog(){
        try {
            //获取日志文件根目录
            String url = System.getProperty("catalina.home");
            String nTime = TimeTools.getTimeByBeforeDay(tomcatProperties.getMaxsavecount());
            File catalina = new File(url + "\\logs\\catalina." + nTime + ".log");
            File hostManager = new File(url + "\\logs\\host-manager." + nTime + ".log");
            File localhost = new File(url + "\\logs\\localhost." + nTime + ".log");
            File localhostAccess = new File(url + "\\logs\\localhost_access_log." + nTime + ".log");
            File manager = new File(url + "\\logs\\manager." + nTime + ".log");
            if(catalina.exists()){
                catalina.delete();
            }
            if(hostManager.exists()){
                hostManager.delete();
            }
            if(localhost.exists()){
                localhost.delete();
            }
            if(localhostAccess.exists()){
                localhostAccess.delete();
            }
            if(manager.exists()){
                manager.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Param []
     * @Return void
     * @Author zs
     * @Date 2019/8/10 9:44
     * 功能描述：定时5分钟批量保存访问记录/登录记录
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void saveAccessToRecord(){
        List<BlogRecordAccess> records = (List<BlogRecordAccess>) redisTools.get(RecordConsts.ACCESS_TO_RECORD);
        List<BlogRecordLogin> logins = (List<BlogRecordLogin>) redisTools.get(RecordConsts.LOGIN_RECORD);
        if(records != null && records.size() > 0){
            timedTastService.saveAccessToRecord(records);
            //删除redis中已保存的集合
            redisTools.del(RecordConsts.ACCESS_TO_RECORD);
        }
        if(logins != null && logins.size()>0){
            timedTastService.saveRecordLogin(logins);
            //删除redis中已保存的集合
            redisTools.del(RecordConsts.LOGIN_RECORD);
        }
    }
}
