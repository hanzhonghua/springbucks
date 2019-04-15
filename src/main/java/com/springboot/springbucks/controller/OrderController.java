package com.springboot.springbucks.controller;

import com.google.common.collect.Maps;
import com.springboot.springbucks.entity.OrderCoffee;
import com.springboot.springbucks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description: order
 * @author: HanZhonghua
 * @create: 2019-03-17 21:14
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public Map<String, Object> createOrder(String customer, List<OrderCoffee> coffees){

        Long orderId = orderService.createOrder(customer, coffees);
        return buildResult(orderId);
    }

    private Map<String, Object> buildResult(Long orderId){

        Map<String, Object> map = Maps.newHashMap();
        map.put("code", 200);
        map.put("desc", orderId);
        return map;
    }
}
