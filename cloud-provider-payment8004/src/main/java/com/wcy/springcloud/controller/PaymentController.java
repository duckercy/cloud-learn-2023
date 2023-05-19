package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Payment;
import com.wcy.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/testZk")
    public Result<?> testZk(){
        return Result.ok("springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString());
    }
}
