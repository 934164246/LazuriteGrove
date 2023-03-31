package com.rurigokou.back.config;

import com.rurigokou.common.utils.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author gokoururi
 * Redis配置类
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, String> template = new RedisTemplate<>();

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

        template.setConnectionFactory(factory);
        // 设置key的序列化方式
        template.setKeySerializer(stringSerializer);
        // 设置value的序列化方式
        template.setValueSerializer(serializer);
        // 设置hash的key的序列化方式
        template.setHashKeySerializer(stringSerializer);
        // 设置hash的value的序列化方式
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisUtils redisUtils(RedisTemplate<String, String> redisTemplate) {
        RedisUtils redisUtils=new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);

        return redisUtils;
    }
}