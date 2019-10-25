package org.personal.blog.service;

import org.personal.blog.bean.BlogRecordAccess;
import org.personal.blog.bean.BlogRecordLogin;

import java.util.List;

/**
 * Created by zs on 2019/8/10
 */
public interface SystemTimedTastService {
    void saveAccessToRecord(List<BlogRecordAccess> recordsList);

    void saveRecordLogin(List<BlogRecordLogin> logins);
}
