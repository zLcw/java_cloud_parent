package com.jianli.service.iot.controller;

import com.sixing.jianli.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-15 10:34
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public Result test(){
        return Result.success();
    }
}
