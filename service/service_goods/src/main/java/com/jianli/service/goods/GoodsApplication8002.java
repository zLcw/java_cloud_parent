package com.jianli.service.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-14 15:25
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.jianli.service"})
public class GoodsApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication8002.class, args);
    }
}
