package org.personal.blog.service;

import org.personal.blog.bean.BlogRecordLogin;
import org.personal.blog.bean.BlogUser;

/**
 * Created by zs on 2019/8/1
 */
public interface LoginService {
    void saveRecordLogin(BlogRecordLogin recordLogin);

    BlogUser getUser(String userName);

    BlogUser getUserByEmail(String email);
}
