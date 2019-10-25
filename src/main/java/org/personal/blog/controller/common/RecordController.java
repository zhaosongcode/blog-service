package org.personal.blog.controller.common;

import org.personal.blog.bean.BlogRecordAccess;
import org.personal.blog.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zs on 2019/8/10
 * 记录类接口
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/accessToRecord/save")
    public Object saveAccessToRecord(BlogRecordAccess blogRecordAccess){
        return recordService.saveAccessToRecord(blogRecordAccess);
    }
}
