package org.personal.blog.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zs on 2019/7/31
 * 读取对应的配置文件进行参数注入
 */

@PropertySource(value={"classpath:/config.properties"})
@Configuration
@Getter
@Setter
public class TomcatProperties {

    @Value("${log.maxsavecount}")
    private Integer maxsavecount;
}
