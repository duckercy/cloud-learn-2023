package com.wcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class MainApplicationConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationConfig3344.class,args);
    }
}
