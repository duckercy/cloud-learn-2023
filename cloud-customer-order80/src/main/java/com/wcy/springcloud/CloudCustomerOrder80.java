package com.wcy.springcloud;

import com.wcy.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class CloudCustomerOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudCustomerOrder80.class, args);
    }

}
