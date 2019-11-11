package org.personal.blog.pojo.entity;

import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {
    /**
     * 主键id
     */
    @Id
    @Column(name = "pk_id")
    private Integer pkId;

    /**
     * 权限父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 权限名称
     */
    @Column(name = "perm_name")
    private String permName;

    /**
     * 权限路径
     */
    @Column(name = "perm_url")
    private String permUrl;

    /**
     * 菜单样式
     */
    @Column(name = "perm_icon")
    private String permIcon;

    /**
     * 备注
     */
    private String note;

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
     * 获取权限父id
     *
     * @return parent_id - 权限父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置权限父id
     *
     * @param parentId 权限父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取权限名称
     *
     * @return perm_name - 权限名称
     */
    public String getPermName() {
        return permName;
    }

    /**
     * 设置权限名称
     *
     * @param permName 权限名称
     */
    public void setPermName(String permName) {
        this.permName = permName;
    }

    /**
     * 获取权限路径
     *
     * @return perm_url - 权限路径
     */
    public String getPermUrl() {
        return permUrl;
    }

    /**
     * 设置权限路径
     *
     * @param permUrl 权限路径
     */
    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    /**
     * 获取菜单样式
     *
     * @return perm_icon - 菜单样式
     */
    public String getPermIcon() {
        return permIcon;
    }

    /**
     * 设置菜单样式
     *
     * @param permIcon 菜单样式
     */
    public void setPermIcon(String permIcon) {
        this.permIcon = permIcon;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }
}