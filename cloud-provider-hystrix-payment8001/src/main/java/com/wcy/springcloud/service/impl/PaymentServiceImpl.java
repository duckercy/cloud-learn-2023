package com.wcy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wcy.springcloud.entity.Result;
import com.wcy.springcloud.service.PaymentService;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.RescaleOp;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_ok,id="+id+"\t"+"###";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_handle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int l =10/0;
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_Timeout,id="+id+"\t"+"耗时5秒";
    }

    @Override
    public String testCon(Integer id) {
        String s = "进入服务端，准备返回！";
        return s;
    }


    public String paymentInfo_handle(Integer id){
        return "线程池："+Thread.currentThread().getName()+"系统繁忙，请稍候再试，id:"+id+"@@@@@@";
    }



    //---------------服务熔断-------------------------
    //在时间窗口期10秒内，请求10次，失败率达到60%跳闸
    @HystrixCommand(fallbackMethod = "paymentCircleBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    @Override
    public String paymentCircleBreaker(@RequestParam(value = "id")Integer id){
        if (id<0){
            throw new RuntimeException("id 不能为负数！");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+" 调用成功，流水号:"+serialNum;
    }



    public String paymentCircleBreaker_fallback(@RequestParam(value = "id")Integer id){
        return "id 不能为负数，请稍候再试，@！@@！id:"+id;
    }


}
