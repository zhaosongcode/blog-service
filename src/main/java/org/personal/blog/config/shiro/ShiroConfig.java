package org.personal.blog.config.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.personal.blog.properties.RedisProperties;
import org.personal.blog.properties.SessionPropety;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zs on 2019/7/29
 * shiro配置类
 */
@Configuration
public class ShiroConfig {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * @Param [securityManager 安全管理器]
     * @Return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     * @Author zs
     * @Date 2019/7/30 17:45
     * 功能描述：shiro过滤器
     */
    @Bean(name = "shirFilter")
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") SecurityManager securityManager) throws Exception {
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 此路径不是页面，是后台接口,不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/main/index");
        //未授权界面;该配置无效
        //shiroFilterFactoryBean.setUnauthorizedUrl("/main/index");
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //filterChainDefinitionMap.put("/favicon.ico","anon");
        //filterChainDefinitionMap.put("/login","anon");
        //解锁用户专用 测试用的
        //filterChainDefinitionMap.put("/unAccountTest/**","anon");
        //*************************************************
        //filterChainDefinitionMap.put("/**","authc");
        filterChainDefinitionMap.put("/main/**","authc");
        filterChainDefinitionMap.put("/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * @Param []
     * @Return org.personal.blog.properties.RedisProperties
     * @Author zs
     * @Date 2019/7/31 18:51
     * 功能描述：注入redis相关属性
     */
    @Bean(name = "redisPorpertes")
    public RedisProperties getRedisProper(){
        return new RedisProperties();
    }

    /**
     * @Param [sessionManager, cacheManager]
     * @Return org.apache.shiro.mgt.SecurityManager
     * @Author zs
     * @Date 2019/7/30 17:50
     * 功能描述：配置核心安全事务管理器
     */
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
        DefaultSecurityManager manager = new DefaultWebSecurityManager();
        //设置自定义shiroRealm
        manager.setRealm(shiroRealm);
        //配置记住我
        manager.setRememberMeManager(rememberMeManager());
        //配置redis缓存
        manager.setCacheManager(cacheManager());
        //配置自定义session管理，使用redis
        manager.setSessionManager(sessionManager());
        return  manager;
    }

    /**
     * @Param []
     * @Return org.apache.shiro.spring.LifecycleBeanPostProcessor
     * @Author zs
     * @Date 2019/7/30 18:11
     * 功能描述：配置Shiro生命周期处理器
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /**
     * @Param [credentialsMatcher]
     * @Return org.personal.blog.config.shiro.ShiroRealm
     * @Author zs
     * @Date 2019/7/30 17:58
     * 功能描述：创建shiroRealm
     */
    @Bean(name="shiroRealm")
    public ShiroRealm getShiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        //配置自定义密码比较器
        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        shiroRealm.setAuthenticationCachingEnabled(true);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
        shiroRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        shiroRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        shiroRealm.setAuthorizationCacheName("authorizationCache");
        return shiroRealm;
    }

    /**
     * @Param []
     * @Return org.personal.blog.config.shiro.CredentialsMatcher
     * @Author zs
     * @Date 2019/7/30 17:58
     * 功能描述：创建自定义的密码处理器
     */
    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher(){
        return new CredentialsMatcher();
    }

    /**
     * @Param [securityManager]
     * @Return AuthorizationAttributeSourceAdvisor
     * @Author zs
     * @Date 2019/7/30 18:14
     * 功能描述：开启shiro 注解模式
     * 可以在controller中的方法前加上注解
     * 如 @RequiresPermissions("userInfo:add")
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * @Param []
     * @Return SimpleCookie
     * @Author zs
     * @Date 2019/7/30 18:16
     * 功能描述：cookie对象;会话Cookie模板 ,默认为: JSESSIONID 问题: 与SERVLET容器名冲突
     * 重新定义为sid或rememberMe，自定义
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(getSessionProperty().getRembermeTimeout());
        return simpleCookie;
    }

    /**
     * @Param []
     * @Return CookieRememberMeManager
     * @Author zs
     * @Date 2019/7/30 18:17
     * 功能描述：cookie管理对象;记住我功能,rememberMe管理器
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * @Param []
     * @Return FormAuthenticationFilter
     * @Author zs
     * @Date 2019/7/30 18:18
     * 功能描述：FormAuthenticationFilter 过滤器 过滤记住我
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        //对应前端的checkbox的name = rememberMe
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }

    /**
     * @Param []
     * @Return RedisCacheManager
     * @Author zs
     * @Date 2019/7/30 18:18
     * 功能描述：shiro缓存管理器,需要添加到securityManager中
     */
    @Bean(name = "cacheMan")
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        //redis中针对不同用户缓存
        redisCacheManager.setPrincipalIdFieldName("username");
        //用户权限信息缓存时间
        redisCacheManager.setExpire(getSessionProperty().getUserPermissionTimeout());
        return redisCacheManager;
    }

    /**
     * @Param []
     * @Return MethodInvokingFactoryBean
     * @Author zs
     * @Date 2019/7/30 18:20
     * 功能描述：让某个实例的某个方法的返回值注入为Bean的实例
     */
    @Bean
    public MethodInvokingFactoryBean getMethodInvokingFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
        factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        factoryBean.setArguments(new Object[]{securityManager});
        return factoryBean;
    }

    /**
     * @Param []
     * @Return ShiroSessionListener
     * @Author zs
     * @Date 2019/7/30 18:21
     * 功能描述：配置session监听
     */
    @Bean(name = "sessionListener")
    public ShiroSessionListener sessionListener(){
        ShiroSessionListener sessionListener = new ShiroSessionListener();
        return sessionListener;
    }

    /**
     * @Param []
     * @Return SessionIdGenerator
     * @Author zs
     * @Date 2019/7/30 18:22
     * 功能描述：配置会话id生成器
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * @Param []
     * @Return RedisManager
     * @Author zs
     * @Date 2019/7/30 18:23
     * 功能描述：redis
     */
    @Bean(name = "redisManager")
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(getRedisProper().getHost());
        redisManager.setPort(getRedisProper().getPort());
        redisManager.setPassword(getRedisProper().getPassword());
        return redisManager;
    }

    /**
     * @Param []
     * @Return SessionDAO
     * @Author zs
     * @Date 2019/7/30 18:24
     * 功能描述：SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件
     * MemorySessionDAO 直接在内存中进行会话维护
     * EnterpriseCacheSessionDAO  提供了缓存功能的会话维护，默认情况下使用MapCache实现
     * 内部使用ConcurrentHashMap保存缓存的会话。
     */
    @Bean(name = "sessionDAO")
    public SessionDAO sessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        //session在redis中的保存时间,最好大于session会话超时时间
        redisSessionDAO.setExpire(getSessionProperty().getRedisSessionTimeout());
        return redisSessionDAO;
    }

    /**
     * @Param []
     * @Return org.apache.shiro.web.servlet.SimpleCookie
     * @Author zs
     * @Date 2019/7/30 18:36
     * 功能描述：配置保存sessionId的cookie
     */
    @Bean(name = "sessionIdCookie")
    public SimpleCookie sessionIdCookie(){
        //这个参数是cookie的名称
        SimpleCookie simpleCookie = new SimpleCookie(getSessionProperty().getCookieName());
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        //maxAge=-1表示浏览器关闭时失效此Cookie
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    /**
     * @Param []
     * @Return org.personal.blog.properties.SessionPropety
     * @Author zs
     * @Date 2019/7/31 18:50
     * 功能描述：注入session相关属性
     */
    @Bean
    public SessionPropety getSessionProperty(){
        return new SessionPropety();
    }

    @Bean(name = "sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        Collection<SessionListener> listeners = new ArrayList<>();
        //配置监听
        listeners.add(sessionListener());
        sessionManager.setSessionListeners(listeners);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        sessionManager.setSessionDAO(sessionDAO());
        sessionManager.setCacheManager(cacheManager());

        //全局会话超时时间（单位毫秒），默认30分钟  暂时设置为10秒钟 用来测试
        sessionManager.setGlobalSessionTimeout(getSessionProperty().getGlobeSessionTimeout());
        //是否开启删除无效的session对象  默认为true
        sessionManager.setDeleteInvalidSessions(true);
        //是否开启定时调度器进行检测过期session 默认为true
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话 默认为 1个小时
        //设置该属性 就不需要设置 ExecutorServiceSessionValidationScheduler 底层也是默认自动调用ExecutorServiceSessionValidationScheduler
        //暂时设置为 5秒 用来测试
        sessionManager.setSessionValidationInterval(getSessionProperty().getSessionValidationInterval());
        //取消url 后面的 JSESSIONID
        //sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;

    }
}
