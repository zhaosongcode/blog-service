package org.personal.blog.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_user")
public class BlogUser implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称(不可重复)
     */
    @Id
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最新修改时间
     */
    @Column(name = "updata_time")
    private Date updataTime;

    /**
     * 是否删除 (0/否 1/是)
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 用户描述
     */
    private String remarks;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称(不可重复)
     *
     * @return user_name - 用户名称(不可重复)
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称(不可重复)
     *
     * @param userName 用户名称(不可重复)
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取用户手机号
     *
     * @return phone - 用户手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号
     *
     * @param phone 用户手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户邮箱
     *
     * @return email - 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱
     *
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户创建时间
     *
     * @return create_time - 用户创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置用户创建时间
     *
     * @param createTime 用户创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最新修改时间
     *
     * @return updata_time - 最新修改时间
     */
    public Date getUpdataTime() {
        return updataTime;
    }

    /**
     * 设置最新修改时间
     *
     * @param updataTime 最新修改时间
     */
    public void setUpdataTime(Date updataTime) {
        this.updataTime = updataTime;
    }

    /**
     * 获取是否删除 (0/否 1/是)
     *
     * @return is_delete - 是否删除 (0/否 1/是)
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 (0/否 1/是)
     *
     * @param isDelete 是否删除 (0/否 1/是)
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取用户描述
     *
     * @return describe - 用户描述
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置用户描述
     *
     * @param describe 用户描述
     */
    public void setRemarks(String describe) {
        this.remarks = describe;
    }
}
