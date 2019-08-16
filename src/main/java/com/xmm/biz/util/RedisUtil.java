package com.xmm.biz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis根据手机号校验验证码是否正确
     */
    public boolean verifyRandomCodeByPhone(String phone,String randomCode) throws Exception{
        String redisCode = (String)redisTemplate.opsForValue().get(phone);
        if(redisCode == null || !redisCode.equals(randomCode)){//验证码不存在或不匹配
            return false;
        }
        redisTemplate.delete(phone);//删除已验证
        return true;
    }

    /**
     * redis保存手机号和验证码
     */
    public void addRandomCodeByPhone(String phone,String randomCode) throws Exception{
        redisTemplate.opsForValue().set(phone,randomCode,30, TimeUnit.MINUTES);
    }
}
