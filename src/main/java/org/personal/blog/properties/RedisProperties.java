package org.personal.blog.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zs on 2019/7/31
 * 将配置文件参数注解到类进行参数绑定
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    //域名
    @Value("${spring.redis.host}")
    private String host;
    //端口
    @Value("${spring.redis.port}")
    private Integer port;
    //密码
    @Value("${spring.redis.password}")
    private String password;
}
