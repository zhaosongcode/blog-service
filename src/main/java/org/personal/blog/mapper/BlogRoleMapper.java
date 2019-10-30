package org.personal.blog.mapper;

import org.personal.blog.pojo.entity.BlogRole;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface BlogRoleMapper extends BaseMapper<BlogRole> {
    int insertBatch(List<BlogRole> users);
}
