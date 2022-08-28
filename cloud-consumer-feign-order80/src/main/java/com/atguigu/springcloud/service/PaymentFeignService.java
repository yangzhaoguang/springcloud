package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 业务类接口
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/7 13:14
 * Description:
 */
@Component
// 使用 Feign，指定调用的服务名
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 根据 ID 查询
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")   // 向服务接口发送请求
    // CommonResult<Payment> 调用远程服务返回值类型
   CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 演示 OpenFeign 超时控制
     * @return
     */
    @GetMapping("/payment/feign/timeOut")
    String PaymentFeignTimeOut();
}
