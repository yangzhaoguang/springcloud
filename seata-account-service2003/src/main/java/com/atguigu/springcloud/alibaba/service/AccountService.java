package com.atguigu.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/7/2 16:46
 * Description:
 */
public interface AccountService {
    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Double money);
}
