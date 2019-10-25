package org.personal.blog.mapper;

import org.personal.blog.bean.BlogRole;
import org.personal.blog.config.mapper.MyMapper;

import java.util.List;

public interface BlogRoleMapper extends MyMapper<BlogRole> {
    List<String> getRoleNamesByRoleId(String[] roleIds1);
}