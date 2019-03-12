package com.springboot.springbucks.mapper;

import com.springboot.springbucks.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @description: mapper
 * @author: HanZhonghua
 * @create: 2019-03-10 21:21
 */
public interface OrderMapper {
    public Order getById(@Param("id") Integer id);
}
