package com.bjsxt;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableApolloConfig
public class Eureka_7003_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_7003_StartSpringCloudApplication.class,args);
    }
}
