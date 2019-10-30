package org.personal.blog.mapper;

import org.personal.blog.pojo.entity.BlogRolePermission;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface BlogRolePermissionMapper extends BaseMapper<BlogRolePermission> {
    void insertBatch(List<BlogRolePermission> users);
}
