package org.personal.blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zs on 2019/7/31
 * 获取配置文件参数工具类
 * 该类的工作原理是利用Java的类加载机制
 * 你要通过该工具类获取属性值，则先要加载这个工具类的静态代码块balabala~
 * 反正是他会先从配置文件中读取属性，然后返回给你
 */
public class PropertyTools {

    private static final Logger logger = LoggerFactory.getLogger(PropertyTools.class);
    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        logger.info("start to load properties.......");
        props = new Properties();
        InputStream in = null;
        try {

            in = PropertyTools.class.getClassLoader().
                    getResourceAsStream("application.properties"); //具体什么文件就写什么
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("properties not found!");
        } catch (IOException e) {
            logger.error("IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("properties close Exception!");
            }
        }
        // logger.info(props);
        logger.info("load properties over...........");
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

}
