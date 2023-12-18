package com.jianli.service.ucenter.controller;

import com.sixing.jianli.constant.RedisKey;
import com.sixing.jianli.utils.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 10:06
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Value("${spring.redis.host}")
    private String port;

    @RequestMapping("/login")
    public String test(){
        log.info("port:",port);
        String test = JwtHelper.createToken("1", "test");
        String redisKey = RedisKey.REDIS_KEY_PREFIX + "1";
        redisTemplate.opsForValue().set(redisKey,test,2, TimeUnit.MINUTES);
        return test;
    }
}
