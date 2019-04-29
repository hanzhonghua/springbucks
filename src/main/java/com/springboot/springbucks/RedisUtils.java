package com.springboot.springbucks;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description: redisutils
 * @author: HanZhonghua
 * @create: 2019-04-16 22:09
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 设置key失效时间
     * @param key
     * @param time
     * @return
     */
    public Boolean expire(String key,long time ) {
        return  redisTemplate.expire(key, time, TimeUnit.HOURS);
    }

    public void set(String key, String val, long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key,val,time,timeUnit);
    }

    public Boolean setnx(String key, String value){
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    public Boolean sethnx(String key, String key1, String value){
        return redisTemplate.opsForHash().putIfAbsent(key,key1,value);
    }

    /**
     * 取key失效时间
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        return  redisTemplate.getExpire(key);
    }

    /**
     * 压栈
     *
     * @param key
     * @param value
     * @return
     */
    public Long pushLs(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 失效设置
     *
     * @param key
     * @param timeout
     * @param unit
     */
    public void expireKey(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 出栈
     *
     * @param key
     * @return
     */
    public String popLs(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 入队
     *
     * @param key
     * @param value
     * @return
     */
    public Long inLs(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 批量入队列
     *
     * @param ls
     * @return
     */
    public void queueIn(String key, List<Long> ls) {
        for (Long tmp : ls){
            redisTemplate.opsForList().rightPush(key, tmp+"");
        }
    }

    /**
     * 出队
     *
     * @param key
     * @return
     */
    public String outLs(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 批量出队列
     *
     * @param key
     * @return
     */
    public List<Long> queueQut(String key,int range) {
        List<Long> result = Lists.newArrayList();
        for (int i=0;i<= range;i++){
            result.add(Long.valueOf(outLs(key)));
        }
        return result;
    }

    /**
     * 栈/队列长
     *
     * @param key
     * @return
     */
    public Long lengthLs(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 范围检索
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> rangeLs(String key, int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 移除
     *
     * @param key
     * @param i
     * @param value
     */
    public void removeLs(String key, long i, String value) {
        redisTemplate.opsForList().remove(key, i, value);
    }

    /**
     * 检索
     *
     * @param key
     * @param index
     * @return
     */
    public String indexLs(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    public void setVal(String k, String v) {
        redisTemplate.opsForValue().set(k, v);
    }

    public String getVal(String k) {
        return redisTemplate.opsForValue().get(k);
    }

    public long increase(String K, long gap){
        return redisTemplate.opsForValue().increment(K, gap);
    }

    /**
     * 获取HSET P操作项
     *
     * @return
     * @throws Exception
     */
    public void decrBy(String key, int value) {
        RedisConnection coonect = redisTemplate.getConnectionFactory().getConnection();
        coonect.decrBy(key.getBytes(), value);
    }

    /**
     * 获取MAP操作项
     *
     * @return
     */
    public void setMap(String k1, String k2, String v) {
        redisTemplate.opsForHash().put(k1, k2, v);
    }

    /**
     * 获取MAP操作项
     *
     * @return
     */
    public String getMap(String k1, String k2) {
        return (String) redisTemplate.opsForHash().get(k1, k2);
    }

    /**
     * 删除MAP操作项
     *
     * @return
     */
    public void deleteMap(String key) {
        redisTemplate.delete(key);
    }

    public void hdel(String key, String file) {
        redisTemplate.opsForHash().delete(key,file);
    }

    /**
     * 获取HSET P操作项
     *
     * @return
     * @throws Exception
     */
    public Long hincrBy(String key, String field, int value) throws Exception {
        return redisTemplate.opsForHash().increment(key, field, value);
    }

    /**
     * 判断是否某个值是否存在于指定的SET中
     *
     * @param key
     * @param target
     * @return
     * @throws Exception
     */
    public boolean isMember(String key, String target) {
        return redisTemplate.opsForSet().isMember(key, target);
    }

    /**
     * 删除指定的SET中的某个值
     *
     * @param key
     * @param target
     */
    public long removeSetVal(String key, String target) {
        return redisTemplate.opsForSet().remove(key, target);
    }

    /**
     * 模拟弹出栈操作
     *
     * @param key
     * @param target
     * @return
     */
    public long popSetVal(String key, String target) {
        if (!isMember(key, target)) {
            return 0;
        }
        return removeSetVal(key, target);
    }

    /**
     * 往指定的SET中的写入某个值
     *
     * @param key
     * @param target
     * @return
     */
    public long addSetVal(String key, String target) {
        return redisTemplate.opsForSet().add(key, target);
    }

    /**
     * 返回set中的所有数据
     *
     * @param key
     * @return
     */
    public Set<String> smembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }
}
