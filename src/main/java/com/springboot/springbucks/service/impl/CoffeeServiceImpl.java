package com.springboot.springbucks.service.impl;

import com.springboot.springbucks.entity.Coffee;
import com.springboot.springbucks.mapper.CoffeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.springbucks.service.CoffeeService;

/**
 * @description: service impl
 * @author: HanZhonghua
 * @create: 2019-03-10 21:20
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Override
    public Coffee getById(Integer id) {

        return coffeeMapper.getById(id);
    }

    @Override
    public Coffee getByName(String name) {
        return coffeeMapper.getByName(name);
    }
}
