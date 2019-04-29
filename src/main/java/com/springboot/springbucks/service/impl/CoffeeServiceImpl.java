package com.springboot.springbucks.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.springboot.springbucks.RedisUtils;
import com.springboot.springbucks.config.RedisKey;
import com.springboot.springbucks.entity.Coffee;
import com.springboot.springbucks.mapper.CoffeeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.springbucks.service.CoffeeService;

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

        String val = redisUtils.getVal(RedisKey.COFFEE_KEY+id);
        Coffee coffee;
        if(StringUtils.isNotEmpty(val)) {

           coffee = JSONObject.parseObject(val, Coffee.class);
        }else {

            coffee = coffeeMapper.getById(id);
            redisUtils.set(RedisKey.COFFEE_KEY+id,JSONObject.toJSONString(coffee), 10, TimeUnit.MINUTES);
        }
        return coffee;
    }

    @Override
    public Coffee getByName(String name) {
        return coffeeMapper.getByName(name);
    }
}
