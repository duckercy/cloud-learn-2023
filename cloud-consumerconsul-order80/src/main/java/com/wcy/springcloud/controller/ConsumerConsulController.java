package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consul")
public class ConsumerConsulController {

    @Autowired
    private RestTemplate restTemplate;


    public static final String INVOKE_URL = "http://consul-provider-payment";


    @RequestMapping("/testConsul")
    public Result<?> testConsul(){
        Result forObject = restTemplate.getForObject(INVOKE_URL + "/consul/testConsul", Result.class);
        return forObject;
    }
}
