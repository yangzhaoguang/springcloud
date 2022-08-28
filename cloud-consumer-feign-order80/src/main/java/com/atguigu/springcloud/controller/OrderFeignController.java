package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/7 13:26
 * Description:
 */
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return  paymentFeignService.getPaymentById(id);
    }

    /**
     *演示OpenFeign的超时控制
     * @return
     */
    @GetMapping("/consumer/payment/feign/timeOut")
    public String PaymentFeignTimeOut(){
        return paymentFeignService.PaymentFeignTimeOut();
    }
}
