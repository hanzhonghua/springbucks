package com.springboot.springbucks.service.impl;

import com.springboot.springbucks.entity.OrderCoffee;
import com.springboot.springbucks.mapper.OrderCoffeeMapper;
import com.springboot.springbucks.service.OrderCoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: ordercoffee
 * @author: HanZhonghua
 * @create: 2019-03-13 23:01
 */
@Service
public class OrderCoffeeServiceImpl implements OrderCoffeeService {

    @Autowired
    private OrderCoffeeMapper orderCoffeeMapper;

    @Override
    public void insert(OrderCoffee orderCoffee) {
        orderCoffeeMapper.insert(orderCoffee);
    }
}
