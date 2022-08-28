package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/7/2 16:26
 * Description:
 */
@FeignClient(value = "seata-storage-service")  // 调用库存微服务
public interface StorageService {
    /**
     * 扣减库存 -》 调用 库存微服务
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
