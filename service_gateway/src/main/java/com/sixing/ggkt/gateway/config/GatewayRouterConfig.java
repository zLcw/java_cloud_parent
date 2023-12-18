package com.sixing.ggkt.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-14 15:32
 * @description 路由配置
 */
@Configuration
public class GatewayRouterConfig {
    @Value("${spring.profiles.active}")
    public String active;

    // 定义服务常量
    public static final String JIANLI_SERVICE_BUILD = "jianli-service-build";
    public static final String JIANLI_SERVICE_GOODS = "jianli-service-goods";
    public static final String JIANLI_SERVICE_IOT = "jianli-service-iot";

    public static final String JIANLI_SERVICE_UCENTER = "jianli-service-ucenter";


    @Bean
    public RouteLocator customRouterConfig(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        System.out.println("------- 开始配置路由 -------");

        Map<String, String> routesMap = new HashMap<>();
        if ("dev".equals(active)) {
            // 走dev配置
            System.out.println("路由检测到线下dev配置，走线下网关");
            routesMap.put(JIANLI_SERVICE_BUILD, "http://127.0.0.1:8001/");
            routesMap.put(JIANLI_SERVICE_GOODS, "http://127.0.0.1:8002/");
            routesMap.put(JIANLI_SERVICE_IOT, "http://127.0.0.1:8004/");
            routesMap.put(JIANLI_SERVICE_UCENTER, "http://127.0.0.1:8005/");
        } else {
            System.out.println("路由检测到线下配置，走线下网关");
            routesMap.put(JIANLI_SERVICE_BUILD, "http://127.0.0.1:8001/");
            routesMap.put(JIANLI_SERVICE_GOODS, "http://127.0.0.1:8002/");
            routesMap.put(JIANLI_SERVICE_IOT, "http://127.0.0.1:8004/");
            routesMap.put(JIANLI_SERVICE_UCENTER, "http://127.0.0.1:8005/");

        }

        System.out.println("------- 配置路由结束 -------");
        return routeBuilder(routes, routesMap).build();
    }

    public RouteLocatorBuilder.Builder routeBuilder(RouteLocatorBuilder.Builder routes, Map<String, String> routesMap) {
        // 装修 - 业务
        routes.route(JIANLI_SERVICE_BUILD, route ->
                route.path("/api/build/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri(routesMap.getOrDefault(JIANLI_SERVICE_BUILD, "lb://jianli-service-build")));

        // 商品 - 业务
        routes.route(JIANLI_SERVICE_GOODS, route ->
                route.path("/api/goods/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri(routesMap.getOrDefault(JIANLI_SERVICE_GOODS, "lb://jianli-service-goods")));

        // 设备 - 业务
        routes.route(JIANLI_SERVICE_GOODS, route ->
                route.path("/api/iot/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri(routesMap.getOrDefault(JIANLI_SERVICE_IOT, "lb://jianli-service-iot")));

        routes.route(JIANLI_SERVICE_UCENTER, route ->
                route.path("/api/ucenter/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri(routesMap.getOrDefault(JIANLI_SERVICE_UCENTER, "lb://jianli-service-ucenter")));

        return routes;
    }
}
