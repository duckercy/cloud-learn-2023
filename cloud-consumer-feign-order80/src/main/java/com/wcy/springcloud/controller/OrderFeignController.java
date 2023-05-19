package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Result;
import com.wcy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/getById")
    public Result<?> getById(@RequestParam(value = "id")Long id){
        return paymentService.getById(id);
    }

    @GetMapping("/payment/testTime")
    public Result<?> testTime(){
        return paymentService.testTime();
    }
}
