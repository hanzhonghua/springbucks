package com.springboot.springbucks.controller;

import com.springboot.springbucks.entity.OrderCoffee;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Test
    public void testCreateOrder(){

        List<OrderCoffee> coffees = Lists.newArrayList();
        OrderCoffee o1 = new OrderCoffee();
        o1.setItemsId(1);
        o1.setCount(2);
        OrderCoffee o2 = new OrderCoffee();
        o2.setItemsId(3);
        o2.setCount(2);
        coffees.add(o1);
        coffees.add(o2);
        orderController.createOrder("Jim", coffees);
    }
}