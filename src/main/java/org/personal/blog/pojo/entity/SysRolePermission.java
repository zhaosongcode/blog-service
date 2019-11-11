package org.personal.blog.pojo.entity;

import javax.persistence.*;

@Table(name = "sys_role_permission")
public class SysRolePermission {
    /**
     * 主键id
     */
    @Id
    @Column(name = "pk_id")
    private Integer pkId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "perm_id")
    private Integer permId;

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
     * @return perm_id - 权限id
     */
    public Integer getPermId() {
        return permId;
    }

    /**
     * 设置权限id
     *
     * @param permId 权限id
     */
    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}