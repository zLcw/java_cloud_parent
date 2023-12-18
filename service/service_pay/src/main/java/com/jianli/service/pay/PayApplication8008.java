package com.jianli.service.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 15:44
 * @description
 */
@EnableDiscoveryClient
@ComponentScan({"com.jianli"})
@SpringBootApplication
@EnableFeignClients
public class PayApplication8008 {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication8008.class,args);
    }
}
