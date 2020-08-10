package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //启用监控服务
public class Hystrix_Dashboard_9001_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hystrix_Dashboard_9001_StartSpringCloudApplication.class,args);
    }

}
