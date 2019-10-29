package org.personal.blog.pojo.entity;

import javax.persistence.*;

@Table(name = "blog_permission")
public class BlogPermission {
    /**
     * 权限id
     */
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 权限父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 权限名称
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限路径
     */
    @Column(name = "permission_url")
    private String permissionUrl;

    /**
     * 菜单样式
     */
    @Column(name = "permission_icon")
    private String permissionIcon;

    /**
     * 备注
     */
    @Column(name = "permission_note")
    private String permissionNote;

    /**
     * 获取权限id
     *
     * @return permission_id - 权限id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限id
     *
     * @param permissionId 权限id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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
     * @return permission_name - 权限名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置权限名称
     *
     * @param permissionName 权限名称
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 获取权限路径
     *
     * @return permission_url - 权限路径
     */
    public String getPermissionUrl() {
        return permissionUrl;
    }

    /**
     * 设置权限路径
     *
     * @param permissionUrl 权限路径
     */
    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    /**
     * 获取菜单样式
     *
     * @return permission_icon - 菜单样式
     */
    public String getPermissionIcon() {
        return permissionIcon;
    }

    /**
     * 设置菜单样式
     *
     * @param permissionIcon 菜单样式
     */
    public void setPermissionIcon(String permissionIcon) {
        this.permissionIcon = permissionIcon;
    }

    /**
     * 获取备注
     *
     * @return permission_note - 备注
     */
    public String getPermissionNote() {
        return permissionNote;
    }

    /**
     * 设置备注
     *
     * @param permissionNote 备注
     */
    public void setPermissionNote(String permissionNote) {
        this.permissionNote = permissionNote;
    }
}