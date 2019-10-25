package org.personal.blog.bean.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zs on 2019/7/30
 */
@Getter
@Setter
public class User implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 最新修改时间
     */
    private Date updataTime;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户描述
     */
    private String remarks;
}
