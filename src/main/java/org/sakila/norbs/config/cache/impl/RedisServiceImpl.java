package org.sakila.norbs.config.cache.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SuppressWarnings("ALL")
@Service
public class RedisServiceImpl extends AbstractRedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }


}
