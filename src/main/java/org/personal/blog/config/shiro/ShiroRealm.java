package org.personal.blog.config.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.personal.blog.bean.BlogUser;
import org.personal.blog.bean.vo.User;
import org.personal.blog.consts.common.CommonConsts;
import org.personal.blog.service.ShiroService;
import org.personal.blog.util.common.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by zs on 2019/7/29
 * shiro权限相关查询验证
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private ShiroService shiroService;

    /**
     * @author zs
     * @date 2019/7/29 18:46
     * 授权
     * 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的
     * 它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示
     * 如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole()); authorizationInfo.addStringPermission(p.getPermission());
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles); authorizationInfo.setStringPermissions(stringPermissions);
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "perms[权限添加]");
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "roles[100002]，perms[权限添加]");
     * 就说明访问/add这个链接必须要有 "权限添加" 这个权限和具有 "100002" 这个角色才可以访问
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("开始查询授权");
        //获取用户的uuid
        BlogUser user = (BlogUser) principalCollection.getPrimaryPrincipal();
        int userId = user.getUserId();
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        //数据库查询角色及权限,添加角色(角色名称)
        authorizationInfo.addRoles(shiroService.getRolesByUuid(userId));
        authorizationInfo.addStringPermissions(shiroService.getPermissionUrlByUserId(userId));
        log.info("授权完成");
        return authorizationInfo;
    }

    /**
     * @author zs
     * @date 2019/7/29 18:47
     * 验证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("开始验证权限");
        UsernamePasswordToken user = (UsernamePasswordToken) authenticationToken;
        String username = user.getUsername();//用户名
        //数据库交互，查询相应用户
        BlogUser userByDateBase = shiroService.getUserByUserName(username);
        if(userByDateBase == null){
            throw new UnknownAccountException();//用户不存在(账号不存在)
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userByDateBase, //用户
                userByDateBase.getUserPassword(), //密码
                //ByteSource.Util.bytes(username),//加盐
                getName()
        );
        //将用户信息放入redis
        User user1 = new User();
        BeanUtils.copyProperties(userByDateBase,user1);
        Session session = Tools.getSession();
        session.setAttribute(CommonConsts.SESSION_USER,user1);
        log.info("认证完成");
        return authenticationInfo;
    }

    /**
     * @Param [principals]
     * @Return void
     * @Author zs
     * @Date 2019/7/30 18:29
     * 功能描述：重写方法,清除当前用户的的 授权缓存
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * @Param [principals]
     * @Return void
     * @Author zs
     * @Date 2019/7/30 18:29
     * 功能描述：重写方法，清除当前用户的 认证缓存
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * @Param []
     * @Return void
     * @Author zs
     * @Date 2019/7/30 18:29
     * 功能描述：自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * @Param []
     * @Return void
     * @Author zs
     * @Date 2019/7/30 18:29
     * 功能描述：自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * @Param []
     * @Return void
     * @Author zs
     * @Date 2019/7/30 18:29
     * 功能描述：自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
