package com.example.demolua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lua")
public class Example {
    @Autowired
    RedisLuaUtils redisLuaUtils;

    @GetMapping("/checkAndSet")
    public Object checkAndSet() {
        return redisLuaUtils.execute(redisLuaUtils.script1(), "buyDO");
    }
}
