package com.wcy.springcloud.service;

import com.wcy.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/getById")
    public Result<?> getById(@RequestParam(value = "id")Long id);

    @GetMapping(value = "/payment/testTime")
    public Result<?> testTime();
}
