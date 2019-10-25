package org.personal.blog.util.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by zs on 2019/8/11
 * 通用工具类
 */
public class Tools {

    /**
     * @Param []
     * @Return org.apache.shiro.session.Session
     * @Author zs
     * @Date 2019/8/11 10:53
     * 功能描述：获取session
     */
    public static Session getSession(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getSession();
    }
}
