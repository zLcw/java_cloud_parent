package com.jianli.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 15:48
 * @description
 */
@SpringBootApplication
@ComponentScan({"com.jianli"})
@EnableDiscoveryClient
@EnableFeignClients
public class OrderApplication8009 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8009.class,args);
    }
}
