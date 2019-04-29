package com.springboot.springbucks.controller;

import com.springboot.springbucks.RedisUtils;
import com.springboot.springbucks.entity.Coffee;
import com.springboot.springbucks.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: coffe
 * @author: HanZhonghua
 * @create: 2019-03-16 23:13
 */
@RestController
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @RequestMapping("/getById")
    public Coffee getById () {

        return coffeeService.getById(1);
    }

}
