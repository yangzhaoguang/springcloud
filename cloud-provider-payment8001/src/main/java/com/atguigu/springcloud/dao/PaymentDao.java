package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 17:25
 * Description:
 */
@Mapper
public interface PaymentDao {

     /**
      * 插入返回主键 ID
      * @param payment
      * @return
      */
     int create(Payment payment);

     /**
      * 根据 ID 查询
      * @param id
      * @return
      */
     Payment getPaymentById(@Param("id") Long id);

}
