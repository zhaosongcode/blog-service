package org.personal.blog.controller.PageJumpController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zs on 2019/8/15
 * 主页面跳转
 */
@RequestMapping("/main")
@Controller
public class MainIndexController {

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/15 9:58
     * 功能描述：登录成功跳转主页面
     */
    @RequestMapping("/index")
    public String mainIndex(){
       return "index";
    }
}
