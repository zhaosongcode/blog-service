package org.personal.blog.bean;

import javax.persistence.*;

@Table(name = "blog_user_role")
public class BlogUserRole {
    /**
     * 用户角色中间表id
     */
    @Id
    @Column(name = "user_role_id")
    private Integer userRoleId;

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
     * 获取用户角色中间表id
     *
     * @return user_role_id - 用户角色中间表id
     */
    public Integer getUserRoleId() {
        return userRoleId;
    }

    /**
     * 设置用户角色中间表id
     *
     * @param userRoleId 用户角色中间表id
     */
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
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