package org.personal.blog.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_record_login")
public class BlogRecordLogin {
    /**
     * 登录记录id
     */
    @Id
    @Column(name = "login_record_id")
    private Integer loginRecordId;

    /**
     * 登录ip
     */
    private String ip;

    /**
     * 登录设备
     */
    private String device;

    /**
     * 创建时间/登录时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 登录地址
     */
    private String address;

    /**
     * 登录浏览器
     */
    private String browser;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 获取登录记录id
     *
     * @return login_record_id - 登录记录id
     */
    public Integer getLoginRecordId() {
        return loginRecordId;
    }

    /**
     * 设置登录记录id
     *
     * @param loginRecordId 登录记录id
     */
    public void setLoginRecordId(Integer loginRecordId) {
        this.loginRecordId = loginRecordId;
    }

    /**
     * 获取登录ip
     *
     * @return ip - 登录ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置登录ip
     *
     * @param ip 登录ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取登录设备
     *
     * @return device - 登录设备
     */
    public String getDevice() {
        return device;
    }

    /**
     * 设置登录设备
     *
     * @param device 登录设备
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * 获取创建时间/登录时间
     *
     * @return create_time - 创建时间/登录时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间/登录时间
     *
     * @param createTime 创建时间/登录时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取登录地址
     *
     * @return address - 登录地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置登录地址
     *
     * @param address 登录地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取登录浏览器
     *
     * @return browser - 登录浏览器
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 设置登录浏览器
     *
     * @param browser 登录浏览器
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }

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
}