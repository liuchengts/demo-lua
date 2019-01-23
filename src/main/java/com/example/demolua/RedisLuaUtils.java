package com.example.demolua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class RedisLuaUtils {

//    static volatile Map<String, String> map = new HashMap<>();

    @Autowired
    RedisTemplate redisTemplate;
    String load_has = "";
    String clean = "lua/clean.lua";
    String load = "lua/load.lua";
    String script1 = "lua/script1.lua";

    @PostConstruct
    private void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
    }

    @Bean
    @Scope
    public RedisScript clean() {
        DefaultRedisScript redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(clean)));
        return redisScript;
    }

    @Bean
    @Scope
    public RedisScript<String> load() {
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(load)));
        redisScript.setResultType(String.class);
        return redisScript;
    }

    @Bean
    @Scope
    public RedisScript<List> script1() {
        DefaultRedisScript<List> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(script1)));
        redisScript.setResultType(List.class);
        return redisScript;
    }

    /**
     * 执行脚本
     *
     * @param redisScript 脚本
     * @param keys
     * @param args
     * @return
     */
    public Object execute(RedisScript redisScript, List<String> keys, Object... args) {
        return redisTemplate.execute(redisScript, keys, args);
    }

    /**
     * 执行脚本
     *
     * @param redisScript 脚本
     * @param key
     * @param args
     * @return
     */
    public Object execute(RedisScript redisScript, String key, Object... args) {
        return redisTemplate.execute(redisScript, Collections.singletonList(key), args);
    }
}
