package org.personal.blog.service;

import org.personal.blog.bean.BlogUser;

import java.util.List;

/**
 * Created by zs on 2019/7/29
 */
public interface ShiroService {

    List<String> getRolesByUuid(int uuid);

    List<String> getPermissionUrlByUserId(int userId);

    BlogUser getUserByUserName(String userId);
}
