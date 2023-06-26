package org.sakila.norbs.config.cache.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.sakila.norbs.config.cache.RedisService;


@SuppressWarnings("ALL")
public abstract class AbstractRedisService implements RedisService {

    public abstract RedisTemplate<String, Object> getRedisTemplate();

    @Override
    public boolean set(String key, Object value) {
        try {
            getRedisTemplate().opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public <T> T get(String key) {
        return key == null ? null : (T) getRedisTemplate().opsForValue().get(key);
    }
}
