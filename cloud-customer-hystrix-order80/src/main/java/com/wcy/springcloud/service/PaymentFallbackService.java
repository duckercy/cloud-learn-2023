package com.wcy.springcloud.service;

import com.wcy.springcloud.entity.Result;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public Result<?> testError(Integer id) {
        return Result.error("服务报错，已返回！");
    }

    @Override
    public Result<?> testOK(Integer id) {
        return Result.error("服务报错，已返回！");
    }

    @Override
    public Result<?> testCon(Integer id) {
        return Result.error("服务报错，已返回！");
    }
}
