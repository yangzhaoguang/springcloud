package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/30 16:30
 * Description:
 */
public class CustomerBlockHandler {

    public static CommonResult customerBlockHandler(BlockException e) {
        return new CommonResult(444, "自定义限流处理逻辑-----1");
    }

    public static CommonResult customerBlockHandler2(BlockException e) {
        return new CommonResult(444, "自定义限流处理逻辑-----1");
    }
}
