package org.personal.blog.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

/**
 * Created by zs on 2019/8/1
 */
public class NumberTools {

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/1 17:06
     * 功能描述：获取32位的UUID
     */
    public static String get32UUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    /**
     * @Param [d,n几位小数]
     * @Return double
     * @Author zs
     * @Date 2019/8/1 17:07
     * 功能描述：保留几位小数
     */
    public static double keepThreePoint(double d, Integer n){
        String forMa = "#.";
        for(int i = 0;i<n;i++){
            forMa += "0";
        }
        DecimalFormat df = new DecimalFormat(forMa);
        String strForMa = df.format(d);
        double result = Double.parseDouble(strForMa);
        return result;
    }

    /**
     * @Param [oldPassword, userName]
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/1 17:10
     * 功能描述：密码加密
     */
    public static String passwordEncry(String password, String userName){
        int hashIterationss = 10;
        SimpleHash simpleHashs = new SimpleHash("MD5",password,userName,hashIterationss);
        String encyPassword = simpleHashs.toHex();
        return encyPassword;
    }

    public static String get4IntNum(){
        String num = "";
        Random ra =new Random();
        for (int i=0;i<4;i++) {
            num += ra.nextInt(10)+1;
        }
        return num;
    }
}
