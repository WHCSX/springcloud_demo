package com.bjsxt.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("mldnjava","hello");
    }

    /**
     * 开启日志输出
     * @return
     */
    @Bean
    public Logger.Level getFeignLoggerLevel(){
        return feign.Logger.Level.FULL;
    }

}
