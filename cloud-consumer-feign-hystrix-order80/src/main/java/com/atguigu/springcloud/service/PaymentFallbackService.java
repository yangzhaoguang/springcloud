package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/13 19:56
 * Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService --- paymentInfo_OK --- o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService --- paymentInfo_TimeOut --- o(╥﹏╥)o";
    }
}
