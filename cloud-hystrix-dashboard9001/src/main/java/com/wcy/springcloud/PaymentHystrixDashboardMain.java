package com.wcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class PaymentHystrixDashboardMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixDashboardMain.class,args);
    }
}
