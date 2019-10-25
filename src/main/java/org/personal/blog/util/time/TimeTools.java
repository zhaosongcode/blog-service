package org.personal.blog.util.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zs on 2019/7/25
 * 时间部分工具类
 */
public class TimeTools {

    /**
     * @author zs
     * @date 2019/7/25
     * 获取N天前的时间
     **/
    public static String getTimeByBeforeDay(int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(System.currentTimeMillis()-(1000*60*60*24)*day);
    }

    /**
     * @Param [date]
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/1 17:12
     * 功能描述：时间格式转换 由date转换为String
     */
    public static String tranTime(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        return format;
    }

    /**
     * @Param [time]
     * @Return java.util.Date
     * @Author zs
     * @Date 2019/8/1 17:13
     * 功能描述：时间格式转换位Date类型
     */
    public static Date StringTimeToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date times = null;
        try {
            times = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

   /**
    * @Param [littleTime, bigTime]
    * @Return long
    * @Author zs
    * @Date 2019/8/1 17:14
    * 功能描述：获取时间差值 long类型
    */
    public static long getDifferentTime(String littleTime, String bigTime){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try {
            Date dateLittleTime = df.parse(littleTime);
            Date dateBigTime = df.parse(bigTime);
            time = dateBigTime.getTime() - dateLittleTime.getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return time;
    }
}
