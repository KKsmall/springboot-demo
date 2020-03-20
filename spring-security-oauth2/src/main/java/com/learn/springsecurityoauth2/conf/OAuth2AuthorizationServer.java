package com.learn.springsecurityoauth2.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/** 资源服务器和授权服务器有可能在不同服务器上
 * 客户端会先请求授权服务器引导用户授权，获得code，然后用code去获得token令牌，之后才能请求资源服务器
 * @author liujin
 * @datetime 2020/3/13 14:06
 */
@Configuration
@EnableAuthorizationServer //配置授权服务器
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() //这里应该是为了简单从内存中读取账户信息，实际情况是在数据库中
                .withClient("clientapp").secret("112233") //这个client指代的是客户端而不是用户
                .redirectUris("http://localhost:8080/callback")
                .authorizedGrantTypes("authorization_code") //授权码模式
                .scopes("read_userinfo", "read_contacts")   //可授权的域
//                .and()..... 还是继续配置
                ;
    }
}
