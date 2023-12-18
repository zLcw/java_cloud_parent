package com.jianli.service.build;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-14 15:02
 * @description
 */
@EnableDiscoveryClient
@ComponentScan({"com.jianli.service"})
@SpringBootApplication
public class BuildApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(BuildApplication8001.class, args);
    }
}
