package com.bjsxt.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

//@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced   //在获取RestTemplate对象的时候加入Ribbon的配置;实现负载均衡的注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders(){    //要进行Http头信息配置
        HttpHeaders headers = new HttpHeaders();    //定义一个Http头信息
        String auth = "mldnjava:hello"; //认证的原始信息
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));    //进行加密处理
        //在进行授权的头信息的内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization",authHeader);
        return headers;
    }

}
