package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公用的返回对象 --- 返回给前端的 JSON
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 17:22
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{
    private Integer code ;
    private String message ;

    // 指定返回的泛型
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
