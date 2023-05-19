package com.wcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentMain8004.class,args);
    }
}
