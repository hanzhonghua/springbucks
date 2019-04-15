package com.springboot.springbucks.service;

import com.springboot.springbucks.entity.Order;
import com.springboot.springbucks.entity.OrderCoffee;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: coffee service
 * @author: HanZhonghua
 * @create: 2019-03-10 21:18
 */
public interface OrderService {

    Order getById(Integer id);

    void save(Order order);

    Long createOrder(String customer, List<OrderCoffee> orderCoffees);
    Boolean payOrder(Long orderId);
}
