package com.jianli.service.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-18 10:05
 * @description
 */
@ComponentScan({"com.jianli"})
@EnableDiscoveryClient
@SpringBootApplication
public class UcenterApplication8005 {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication8005.class, args);
    }
}
