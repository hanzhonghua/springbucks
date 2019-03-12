package com.springboot.springbucks.service;

import com.springboot.springbucks.entity.Coffee;

/**
 * @description: coffee service
 * @author: HanZhonghua
 * @create: 2019-03-10 21:18
 */
public interface CoffeeService {

    Coffee getById(Integer id);
}
