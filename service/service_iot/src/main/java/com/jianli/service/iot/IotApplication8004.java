package com.jianli.service.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-15 10:24
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.jianli.service"})
public class IotApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(IotApplication8004.class, args);
    }
}
