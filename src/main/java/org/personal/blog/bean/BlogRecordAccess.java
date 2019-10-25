package org.personal.blog.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_record_access")
public class BlogRecordAccess {
    /**
     * 访问记录id
     */
    @Id
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * 访问ip
     */
    private String ip;

    /**
     * 访问设备
     */
    private String device;

    /**
     * 创建时间/访问时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 访问地址
     */
    private String address;

    /**
     * 访问浏览器
     */
    private String browser;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * sessionId
     */
    private String sessionId;

    /**
     * 获取访问记录id
     *
     * @return record_id - 访问记录id
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * 设置访问记录id
     *
     * @param recordId 访问记录id
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取访问ip
     *
     * @return ip - 访问ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置访问ip
     *
     * @param ip 访问ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取访问设备
     *
     * @return device - 访问设备
     */
    public String getDevice() {
        return device;
    }

    /**
     * 设置访问设备
     *
     * @param device 访问设备
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * 获取创建时间/访问时间
     *
     * @return create_time - 创建时间/访问时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间/访问时间
     *
     * @param createTime 创建时间/访问时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取访问地址
     *
     * @return address - 访问地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置访问地址
     *
     * @param address 访问地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取访问浏览器
     *
     * @return browser - 访问浏览器
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 设置访问浏览器
     *
     * @param browser 访问浏览器
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
