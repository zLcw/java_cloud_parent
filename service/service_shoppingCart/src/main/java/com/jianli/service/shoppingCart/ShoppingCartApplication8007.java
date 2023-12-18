package com.jianli.service.shoppingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 15:41
 * @description
 */
@ComponentScan({"com.jianli"})
@EnableDiscoveryClient
@SpringBootApplication
public class ShoppingCartApplication8007 {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication8007.class, args);
    }
}
