package org.personal.blog.pojo.entity;

import javax.persistence.*;

@Table(name = "sys_dict")
public class SysDict {
    /**
     * 主键id
     */
    @Id
    @Column(name = "pk_id")
    private Integer pkId;

    /**
     * 字典名称
     */
    @Column(name = "dict_name")
    private String dictName;

    /**
     * 字典编码
     */
    @Column(name = "dict_code")
    private String dictCode;

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
     * 获取字典名称
     *
     * @return dict_name - 字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置字典名称
     *
     * @param dictName 字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取字典编码
     *
     * @return dict_code - 字典编码
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 设置字典编码
     *
     * @param dictCode 字典编码
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
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