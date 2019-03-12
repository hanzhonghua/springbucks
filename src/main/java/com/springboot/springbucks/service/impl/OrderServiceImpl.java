package com.springboot.springbucks.service.impl;

import com.springboot.springbucks.entity.Coffee;
import com.springboot.springbucks.entity.Order;
import com.springboot.springbucks.mapper.CoffeeMapper;
import com.springboot.springbucks.mapper.OrderMapper;
import com.springboot.springbucks.service.CoffeeService;
import com.springboot.springbucks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: service impl
 * @author: HanZhonghua
 * @create: 2019-03-10 21:20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getById(Integer id) {

        return orderMapper.getById(id);
    }
}
