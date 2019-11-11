package org.personal.blog.pojo.entity;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    /**
     * 主键id
     */
    @Id
    @Column(name = "pk_id")
    private Integer pkId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

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
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}