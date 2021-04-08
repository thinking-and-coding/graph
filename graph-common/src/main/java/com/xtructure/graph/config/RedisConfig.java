package com.xtructure.graph.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Description: // Redis配置类
 * <p>
 * Created by wangziren on 2021/4/8.
 * Create time: 6:32 下午
 */
@Slf4j
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * Lettuce配置
     *
     * @param lettuceConnectionFactory 连接工厂
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        // TODO
        return null;
    }

    @Bean
    @Override
    public CacheResolver cacheResolver() {
        // TODO
        return null;
    }

    @Bean(value = "mykeyGenerator")
    @Override
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o.getClass().getName()).append(".");
            stringBuilder.append(method.getName()).append(".");
            stringBuilder.append(Arrays.stream(objects).map(Object::toString).collect(Collectors.joining(".")));
            log.debug("|->RedisConfig.keyGenerator.stringBuilder:{}", stringBuilder.toString());
            return stringBuilder.toString();
        };
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        // TODO
        return null;
    }
}
