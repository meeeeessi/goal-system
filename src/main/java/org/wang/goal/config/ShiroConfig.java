package org.wang.goal.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wang.goal.shiro.realm.UserRealm;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //在thymeleaf中使用shiro的自定义tag
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    //1.创建shiroFilter   负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源
        //配置系统公共资源
        Map<String,String> map=new HashMap<String, String>();
        map.put("/com/login","anon");//anon 设置为公共资源 放行资源放在下面
        map.put("/com/register","anon");
        map.put("/com/logout","anon");
        map.put("/user/login","anon");
        map.put("/static/**", "anon");
        map.put("/**","authc");//authc请求这个资源需要认证和授权

        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/com/login");

        //设置拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //3.创建自定义realm
    @Bean
    public Realm getRealm(){
        UserRealm userRealm=new UserRealm();

        //修改凭证校验匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为MD5
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        hashedCredentialsMatcher.setHashIterations(1024);
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);


        //开启缓存管理
//        userRealm.setCacheManager(new EhCacheManager());
//        userRealm.setCachingEnabled(true);//开启全局缓存
//        userRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
//        userRealm.setAuthenticationCacheName("authenticationCache");
//        userRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
//        userRealm.setAuthorizationCacheName("authorizationCache");

        return userRealm;
    }

}
