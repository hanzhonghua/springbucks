package com.springboot.springbucks.mapper;

import com.springboot.springbucks.entity.Coffee;
import org.apache.ibatis.annotations.Param;

/**
 * @description: mapper
 * @author: HanZhonghua
 * @create: 2019-03-10 21:21
 */
public interface CoffeeMapper {
    Coffee getById(@Param("id") Integer id);

    Coffee getByName(@Param("name") String name);
}
