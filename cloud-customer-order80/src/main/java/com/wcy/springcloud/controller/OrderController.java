package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Payment;
import com.wcy.springcloud.entity.Result;
import com.wcy.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/order80")
public class OrderController {


    private static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/payment/create")
    public Result<?> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,Result.class);

    }

    @GetMapping("/payment/getById")
    public Result<?> getById(@RequestParam(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getById?id="+id,Result.class);
    }

    @GetMapping("/lb")
    public String getPaymentLb(){
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (list==null || list.size()<=0){
            return null;
        }
        ServiceInstance instances = loadBalancer.instances(list);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
