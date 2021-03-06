package com.sphere.mybatis.config;

import com.sphere.mybatis.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ly
 * @date 2018/2/23 15:11
 * RedisCache 静态注入函数
 */
@Component
public class RedisCacheTransfer {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Serializable> redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}
