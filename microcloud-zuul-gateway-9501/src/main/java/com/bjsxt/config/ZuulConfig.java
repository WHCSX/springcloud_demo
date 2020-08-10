package com.bjsxt.config;

import com.bjsxt.filter.AuthorizedRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenshuaixin
 * @date 2020/8/8 - 22:28
 */
@Configuration
public class ZuulConfig {

    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter(){
        return new AuthorizedRequestFilter();
    }

}
