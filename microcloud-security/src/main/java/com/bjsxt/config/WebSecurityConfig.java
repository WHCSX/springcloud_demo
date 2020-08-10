package com.bjsxt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //设置不允许做安全访问的路径
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/hystrix.stream","/turbine.stream");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用CSRF保护
        http.csrf().disable();
        //表示所有的访问都必须进行认证处理后才可以正常进行
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        //所有的Rest服务一定要设置为无状态，以提升操作性能
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //这里的修改具体见收藏的网址
        //auth.inMemoryAuthentication().withUser("mldnjava").password("hello").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("mldnjava").password(new BCryptPasswordEncoder().encode("hello")).roles("USER");

    }

}
