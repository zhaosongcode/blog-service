package org.personal.blog.controller.PageJumpController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zs on 2019/8/7
 * 首页部分页面跳转
 */
@RequestMapping("/publicPage/import")
@Controller
public class IndexPageController {

    //公共部分页面位置
    private static final String VIEW = "common/indexCommom/";

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/6 12:00
     * 功能描述：返回头部
     */
    @RequestMapping("/head")
    public String headImport(){
        return VIEW + "head";
    }

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/8 18:21
     * 功能描述：返回主题左部分
     */
    @RequestMapping("/left")
    public String leftImport(){
        return VIEW + "left";
    }
}
