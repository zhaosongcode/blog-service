package org.personal.blog.service;

import org.personal.blog.bean.BlogRecordAccess;


/**
 * Created by zs on 2019/8/10
 */
public interface RecordService {
    Object saveAccessToRecord(BlogRecordAccess blogRecordAccess);
}
