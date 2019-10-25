package org.personal.blog.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zs on 2019/7/31
 * session相关属性注入
 */
@Getter
@Setter
@PropertySource(value={"classpath:/config.properties"})
@Configuration
public class SessionPropety {

    //全局会话超时时间
    @Value("${session.globeSessionTimeout}")
    private Integer globeSessionTimeout;

    //session失效扫描时间
    @Value("${session.SessionValidationInterval}")
    private Integer SessionValidationInterval;

    //cookie的名称
    @Value("${cookie.name}")
    private String cookieName;

    //session在redis中保存的时间
    @Value("${redis.session.timeout}")
    private Integer redisSessionTimeout;

    //用户权限缓存时间
    @Value("${user.permission.timeout}")
    private Integer userPermissionTimeout;

    //记住我cookie生效时间
    @Value("${remberme.timeout}")
    private Integer rembermeTimeout;
}
