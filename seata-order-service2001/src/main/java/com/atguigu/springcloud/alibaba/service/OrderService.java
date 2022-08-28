package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/7/2 16:26
 * Description:
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
