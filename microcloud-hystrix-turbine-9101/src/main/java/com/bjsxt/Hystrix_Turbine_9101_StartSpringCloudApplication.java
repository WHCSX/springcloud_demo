package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard //启用Dashboard监控
@EnableTurbine  //启用Turbine监控
public class Hystrix_Turbine_9101_StartSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hystrix_Turbine_9101_StartSpringCloudApplication.class,args);
    }

}
