package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //启用Eureka客户端
@EnableDiscoveryClient  //启用Eureka发现服务项
@EnableCircuitBreaker   //启用熔断机制
public class Dept_8003_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dept_8003_StartSpringCloudApplication.class,args);
    }

}
