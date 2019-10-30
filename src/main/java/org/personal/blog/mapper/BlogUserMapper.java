package org.personal.blog.mapper;

import org.personal.blog.pojo.entity.BlogUser;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface BlogUserMapper extends BaseMapper<BlogUser> {
    int insertBatch(List<BlogUser> users);
}
