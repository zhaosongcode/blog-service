package org.personal.blog.mapper;

import org.personal.blog.bean.BlogRolePermission;
import org.personal.blog.config.mapper.MyMapper;

import java.util.List;

public interface BlogRolePermissionMapper extends MyMapper<BlogRolePermission> {
    List<String> getPermissionUrlByRoleIds(String[] roleIds);
}