package com.example.demolua.test;

import com.example.demolua.application.RedisLuaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/lua")
public class Example {
    @Autowired
    RedisLuaUtils redisLuaUtils;

//    @Autowired
//    RedisBuyMapper redisBuyMapper;
//
//    @GetMapping("/initData")
//    public Object initData(@RequestParam int count) {
//        for (int i = 0; i < count; i++) {
//            BigDecimal unitPrice = BigDecimal.ONE.add(BigDecimal.valueOf(i));
//            Integer number = 1 + i;
//            redisBuyMapper.save(RedisBuy.builder()
//                    .buyDukeId(1000L + i)
//                    .buyDukeName("name" + i)
//                    .buyNumber(number)
//                    .buyUnitPrice(unitPrice)
//                    .buyPrice(unitPrice.multiply(BigDecimal.valueOf(number)))
//                    .build());
//        }
//        return "ok";
//    }

    //    @SuppressWarnings("all")
//    @GetMapping("/checkAndSet")
//    public List<RedisBuy> checkAndSet() {
//        return (List<RedisBuy>) redisLuaUtils.execute(redisLuaUtils.script1(), "buy");
//    }
    @GetMapping("/only_check_init")
    public void onlyCheckInit() {
        redisLuaUtils.redisTemplate.opsForSet().add("only_check", "a");
        redisLuaUtils.redisTemplate.opsForSet().add("only_check", "b");
        redisLuaUtils.redisTemplate.opsForSet().add("only_check", "c");
        redisLuaUtils.redisTemplate.opsForSet().add("only_check", "d");
    }

    @GetMapping("/only_check")
    public Object onlyCheck() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        return redisLuaUtils.execute(redisLuaUtils.onlyCheck(), "only_check", list);
    }

    @GetMapping("/clean")
    public String clean() {
        return redisLuaUtils.clean();
    }

//    @GetMapping("/load")
//    public String load() {
//        return redisLuaUtils.load();
//    }
}
