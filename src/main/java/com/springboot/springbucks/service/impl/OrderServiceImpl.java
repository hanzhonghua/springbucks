package com.springboot.springbucks.service.impl;

import com.springboot.springbucks.config.ORDER_STATUS;
import com.springboot.springbucks.config.UidConfig;
import com.springboot.springbucks.entity.Order;
import com.springboot.springbucks.entity.OrderCoffee;
import com.springboot.springbucks.mapper.OrderMapper;
import com.springboot.springbucks.service.OrderCoffeeService;
import com.springboot.springbucks.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @description: service impl
 * @author: HanZhonghua
 * @create: 2019-03-10 21:20
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderCoffeeService orderCoffeeService;
    @Autowired
    private UidConfig uidConfig;

    @Override
    public Order getById(Integer id) {

        return orderMapper.getById(id);
    }

    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Long createOrder(String customer, List<OrderCoffee> orderCoffees) {

        Long orderId = uidConfig.genId();
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCustomer(customer);
        order.setOrderStatus(1);
        orderMapper.insert(order);

        if(!CollectionUtils.isEmpty(orderCoffees)) {
            for (OrderCoffee orderCoffee : orderCoffees) {
                orderCoffee.setCoffeeOrderId(orderId);
                orderCoffeeService.insert(orderCoffee);
            }
        }
        log.info("生成订单：{}" + orderId);
        return orderId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean payOrder(Long orderId) {

        Order order = orderMapper.getByOrderId(orderId);
        if(order == null){
            throw new RuntimeException("不存在订单");
        }
        if(order.getOrderStatus() != ORDER_STATUS.INIT.key) {
            throw new RuntimeException("订单以支付");
        }
        orderMapper.updateStatus(orderId, ORDER_STATUS.PAY.key);
        return null;
    }
}
