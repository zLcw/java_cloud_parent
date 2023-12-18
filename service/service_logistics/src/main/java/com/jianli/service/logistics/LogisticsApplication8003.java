package com.jianli.service.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 15:53
 * @description
 */
@SpringBootApplication
@ComponentScan({"com.jianli"})
@EnableDiscoveryClient
public class LogisticsApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication8003.class,args);
    }
}
