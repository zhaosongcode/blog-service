package org.personal.blog.mapper;

import org.personal.blog.pojo.entity.BlogPermission;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface BlogPermissionMapper extends BaseMapper<BlogPermission> {
    int insertBatch(List<BlogPermission> users);
}
