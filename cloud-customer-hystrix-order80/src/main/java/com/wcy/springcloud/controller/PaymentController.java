package com.wcy.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wcy.springcloud.entity.Result;
import com.wcy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;

@RestController
@RequestMapping(value = "/hystrix/order")
@DefaultProperties(defaultFallback = "defaultHystrixErrorMethod")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;


    @GetMapping("/testError")
    @HystrixCommand(fallbackMethod = "hystrixErrorMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public Result<?> testError(@RequestParam(value = "id")Integer id){
        return paymentService.testError(id);
    }


    @GetMapping("/testOk")
//    @HystrixCommand(fallbackMethod = "hystrixErrorMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand
    public Result<?> testOk(@RequestParam(value = "id")Integer id){
        return paymentService.testOK(id);
    }


    @GetMapping(value = "testCon")
    public Result<?> testCon(@RequestParam(value = "id")Integer id){
        return paymentService.testCon(id);
    }

    public Result<?> hystrixErrorMethod(Integer id){
        return Result.error("我是消费者80，远程访问或者本机服务报错！！！！！！！！");
    }

    public Result<?> defaultHystrixErrorMethod(Integer id){
        return Result.error("全局fallback----我是消费者80，远程访问或者本机服务报错！！！！！！！！");
    }
}
