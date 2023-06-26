package org.sakila.norbs.config.cache;


@SuppressWarnings("ALL")
public interface RedisService {

    boolean set(String key, Object value);

    <T> T get(String key);
}
