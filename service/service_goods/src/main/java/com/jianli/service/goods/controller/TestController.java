package com.jianli.service.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-14 16:29
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "goods-test";
    }
}
