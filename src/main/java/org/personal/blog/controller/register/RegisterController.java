package org.personal.blog.controller.register;

import org.personal.blog.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by zs on 2019/9/21
 * 注册
 */
@RestController
@RequestMapping("/register/")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * @Param
     * @Return
     * @Author zs
     * @Date 2019/9/21 10:31
     * 功能描述：注册逻辑
     */
    @RequestMapping("/registerDo")
    public Object registerDo(@RequestParam Map<String,Object> parMap){
        //首先获取登录id
        //获取参数
        registerService.registerDo(parMap);
        return null;
    }
}
