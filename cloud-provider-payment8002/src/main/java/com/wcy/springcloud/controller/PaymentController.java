package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Payment;
import com.wcy.springcloud.entity.Result;
import com.wcy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/getById")
    public Result<?> getById(@RequestParam(value = "id")String id){
        Payment byId = paymentService.getById(id);
        return Result.ok("serverPort:"+serverPort,byId);
    }

    @GetMapping("/testDis")
    public Result<?> testDis(){
        List<String> services = discoveryClient.getServices();
        for (String s:services){
            log.info("service:"+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:instances){
            log.info("instanceId:"+serviceInstance.getInstanceId()+"######host:"+serviceInstance.getHost()+"###port:"+serviceInstance.getPort()+"###uri:"+serviceInstance.getUri());
        }
        return Result.ok(discoveryClient);
    }



    @GetMapping("/lb")
    public Result<?> lb(){
        return Result.ok(serverPort);
    }

    @GetMapping("/testTime")
    public Result<?> testTime(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ok(serverPort);
    }
}
