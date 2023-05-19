package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/consul")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/testConsul")
    public Result<?> testConsul(){
        return Result.ok("springcloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString());
    }
}
