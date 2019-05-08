package com.springboot.springbucks.service.impl;

import com.springboot.springbucks.RedisUtils;
import com.springboot.springbucks.config.RedisKey;
import com.springboot.springbucks.entity.Coffee;
import com.springboot.springbucks.mapper.CoffeeMapper;
import com.springboot.springbucks.service.CoffeeService;
import com.springboot.springbucks.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description: service impl
 * @author: HanZhonghua
 * @create: 2019-03-10 21:20
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeMapper coffeeMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Coffee getById(Integer id) {

        /*String val = redisUtils.getVal(RedisKey.COFFEE_KEY+id);
        Coffee coffee;
        if(StringUtils.isNotEmpty(val)) {

           coffee = JsonUtil.jsonToPoJo(val, Coffee.class);
        }else {
            coffee = coffeeMapper.getById(id);
            String cofeeStr = JsonUtil.objectToJson(coffee);
            redisUtils.set(RedisKey.COFFEE_KEY+id, cofeeStr, 10, TimeUnit.MINUTES);
        }*/

        return coffeeMapper.getById(id);
    }

    @Override
    public Coffee getByName(String name) {
        return coffeeMapper.getByName(name);
    }
}
