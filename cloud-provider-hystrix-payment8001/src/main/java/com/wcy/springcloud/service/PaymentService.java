package com.wcy.springcloud.service;

public interface PaymentService {
    String paymentInfo_ok(Integer id);


    String paymentInfo_Timeout(Integer id);

    String paymentCircleBreaker(Integer id);

    String testCon(Integer id);
}
