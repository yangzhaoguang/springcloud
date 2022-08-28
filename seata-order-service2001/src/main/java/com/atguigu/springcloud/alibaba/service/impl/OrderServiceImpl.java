package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/7/2 16:26
 * Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao ;
    @Autowired
    private AccountService accountService ;
    @Autowired
    private StorageService storageService ;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----- 开始新建订单 ");
        orderDao.create(order);


        //远程调用库存服务扣减库存
        log.info("------->订单微服务调用库存微服务，扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务调用库存微服务，扣减库存结束");

        //远程调用账户服务扣减余额
        log.info("------->订单微服务调用账户微服务，扣减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务调用账户微服务，减余额结束");

        //修改订单状态为已完成
        log.info("------->order-service中修改订单状态开始");
        // 这里的话是不是应该是orderId？
        orderDao.update(order.getUserId(),0);
        log.info("------->order-service中修改订单状态结束");

        log.info("------->下单结束");
    }
}
