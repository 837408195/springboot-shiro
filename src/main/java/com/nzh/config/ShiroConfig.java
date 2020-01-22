package com.nzh.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 倪志浩
 * @program springboot-shiro
 * @packageName com.nzh.config
 * @ClassName ShiroConfig
 * @description
 * @create 2020-01-22
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /**
         * anon:无需认证就可以访问
         * authc:必须认证才能访问
         * user:必须拥有 记住我功能才能使用
         * perms: 拥有对某个权限的资源才能访问
         * role: 拥有某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/unAuthor");
        return bean;

    }
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        return new ShiroRealm();
    }
}
