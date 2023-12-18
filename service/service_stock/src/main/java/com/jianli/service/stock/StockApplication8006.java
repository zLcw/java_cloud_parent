package com.jianli.service.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 15:35
 * @description
 */
@ComponentScan({"com.jianli"})
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class StockApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication8006.class, args);
    }
}
