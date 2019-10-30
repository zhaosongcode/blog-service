package org.personal.blog.mapper;

import org.personal.blog.pojo.entity.BlogUserRole;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface BlogUserRoleMapper extends BaseMapper<BlogUserRole> {
    void insertBatch(List<BlogUserRole> users);
}
