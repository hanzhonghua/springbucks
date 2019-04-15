package com.springboot.springbucks.entity;

import lombok.Data;

/**
 * @description: OrderCoffee
 * @author: HanZhonghua
 * @create: 2019-03-15 21:54
 */
@Data
public class OrderCoffee {

    private Integer id;
    private Long coffeeOrderId;
    private Integer itemsId;
    private Integer count;


}
