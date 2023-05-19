package com.wcy.springcloud.service;

import com.wcy.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/hystrix/payment/testError")
   Result<?> testError(@RequestParam(value = "id") Integer id);

    @GetMapping(value = "/hystrix/payment/testOk")
    Result<?> testOK(@RequestParam(value = "id") Integer id);


    @GetMapping(value = "/hystrix/payment/testCon")
    Result<?> testCon(@RequestParam(value = "id") Integer id);
}
