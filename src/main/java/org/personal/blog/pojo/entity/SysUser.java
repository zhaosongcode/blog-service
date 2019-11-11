package org.personal.blog.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 主键id
     */
    @Id
    @Column(name = "pk_id")
    private Integer pkId;

    /**
     * 账号
     */
    @Column(name = "account_number")
    private String accountNumber;

    /**
     * 密码
     */
    @Column(name = "account_password")
    private String accountPassword;

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
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户描述
     */
    private String remark;

    /**
     * 获取主键id
     *
     * @return pk_id - 主键id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 设置主键id
     *
     * @param pkId 主键id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 获取账号
     *
     * @return account_number - 账号
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 设置账号
     *
     * @param accountNumber 账号
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 获取密码
     *
     * @return account_password - 密码
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     * 设置密码
     *
     * @param accountPassword 密码
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
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
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户描述
     *
     * @return remark - 用户描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置用户描述
     *
     * @param remark 用户描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}