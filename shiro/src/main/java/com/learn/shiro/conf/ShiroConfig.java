package com.learn.shiro.conf;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现对shiro的自定义配置
 * @author liujin
 * @datetime 2020/3/13 14:31
 */
@Configuration
public class ShiroConfig {

    /**
     * Realm 是可以访问程序特定的安全数据如用户、角色、权限等的一个组件
     * Realm 实质上就是一个特定安全的 DAO
     * 每个 Shiro Realm 能够执行身份验证和授权操作。
     * @return
     */
    @Bean
    public Realm realm() {
//      SimpleAccountRealm 是使用内存作为数据源，我们可以手动往里面添加用户、角色、权限等数据。
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("admin", "admin", "ADMIN");
        realm.addAccount("normal", "normal", "NORMAL");
        return realm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//      设置其使用的realm
        securityManager.setRealm(this.realm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
//      创建ShiroFilterFactoryBean对象，用户创建ShiroFilter过滤器，用来拦截请求从而实现shiro的相关功能
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        filterFactoryBean.setSecurityManager(this.securityManager());

        filterFactoryBean.setLoginUrl("login"); //登录url
        filterFactoryBean.setSuccessUrl("/login_success"); //登录成功url
        filterFactoryBean.setUnauthorizedUrl("/unauthorized"); //无权限url 在请求校验权限不通过时，会重定向到该 URL 上。

//      设置url的权限配置
        filterFactoryBean.setFilterChainDefinitionMap(this.filterChainDefinitionMap());

        return filterFactoryBean;
    }

    private Map<String, String> filterChainDefinitionMap() {
        Map<String, String> filterMap = new LinkedHashMap<>(); //需要使用有序的map
        filterMap.put("/test/echo", "anon");    //允许匿名访问
        filterMap.put("/test/admin", "roles[ADMIN]");    //需要ADMIN角色访问
        filterMap.put("/test/normal", "roles[NORMAL]");    //需要NORMAL角色
        filterMap.put("/logout", "logout");    //退出
        filterMap.put("/**", "authc");    //默认剩余的url需要经过认证
        return filterMap;
    }
}
