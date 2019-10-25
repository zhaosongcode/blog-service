package org.personal.blog.bean;

import javax.persistence.*;

@Table(name = "blog_role_permission")
public class BlogRolePermission {
    /**
     * 角色权限中间表id
     */
    @Id
    @Column(name = "role_permission_id")
    private Integer rolePermissionId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 获取角色权限中间表id
     *
     * @return role_permission_id - 角色权限中间表id
     */
    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * 设置角色权限中间表id
     *
     * @param rolePermissionId 角色权限中间表id
     */
    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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
}