package org.personal.blog.pojo.entity;

import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole {
    /**
     * 主键id
     */
    @Id
    @Column(name = "pk_id")
    private Integer pkId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

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
}