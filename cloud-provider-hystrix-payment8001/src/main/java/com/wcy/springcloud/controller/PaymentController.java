package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Result;
import com.wcy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hystrix/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/testOk")
    public Result<?> testOk(@RequestParam(value = "id")Integer id){
        String s = paymentService.paymentInfo_ok(id);
        return Result.ok(s);
    }

    @GetMapping("/testError")
    public Result<?> testError(@RequestParam(value = "id")Integer id){
        return Result.ok(paymentService.paymentInfo_Timeout(id));
    }


    @GetMapping("/testCon")
    public Result<?> testCon(@RequestParam(value = "id")Integer id){
        return Result.ok(paymentService.testCon(id));
    }


    //服务熔断
    @GetMapping("/breaker")
    public Result<?> paymentCircleBreaker(@RequestParam(value = "id")Integer id){
        return Result.ok(paymentService.paymentCircleBreaker(id));
    }
}
