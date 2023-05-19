package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orderZk")
public class OrderZkController {

    @Autowired
    private RestTemplate restTemplate;


    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/paymentInfo")
    public Result<?> paymentInfo(){
        Result forObject = restTemplate.getForObject(INVOKE_URL + "/payment/testZk", Result.class);
        return forObject;
    }
}
