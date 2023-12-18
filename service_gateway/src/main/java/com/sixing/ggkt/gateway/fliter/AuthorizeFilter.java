package com.sixing.ggkt.gateway.fliter;

import com.alibaba.fastjson.JSONObject;
import com.sixing.jianli.constant.RedisKey;
import com.sixing.jianli.constant.ResultCode;
import com.sixing.jianli.result.Result;
import com.sixing.jianli.utils.JwtHelper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-15 15:27
 * @description 全局拦截器，用于判断用户是否登录
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1.获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String uri = request.getURI().toString();
        //放行相关接口
        if (uri.contains("login") || uri.contains("register")){
            return chain.filter(exchange);
        }
        List<String> tokens = request.getHeaders().get("token");
        String token;
        //判断用户是否登录
        if(tokens != null){
            token = tokens.get(0);
            //token验证
            Result result = checkToken(token);

            if(result.getCode() == ResultCode.SUCCESS){
                return chain.filter(exchange);
            }
        }

        response.setStatusCode(HttpStatus.UNAUTHORIZED);//状态码
        String s = JSONObject.toJSONString(Result.fail().code(ResultCode.TOKEN_ERROR).message("token错误，请登录"));
        DataBuffer wrap = response.bufferFactory().wrap(s.getBytes());
        return response.writeWith(Mono.just(wrap));
    }

    @Override
    public int getOrder() {
        return -1;
    }

    public Result checkToken(String token){
        try{
            //解析token 获取用户名称
            String key = JwtHelper.getUserId(token);
            String redisKey = RedisKey.REDIS_KEY_PREFIX + key;
            //根据key从redis中看是否有此token
            String rToken = redisTemplate.opsForValue().get(redisKey);
            if (StringUtils.isEmpty(rToken)){
                return Result.fail().code(ResultCode.TOKEN_ERROR).message("token超时，请登录");
            }
            if (token.equals(rToken)){
                redisTemplate.expire(redisKey,RedisKey.REDIS_KEY_EXPIRE, TimeUnit.MINUTES);
                return Result.success();
            }else{
                return Result.fail().code(ResultCode.TOKEN_ERROR).message("token错误，请登录");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail().code(ResultCode.TOKEN_ERROR).message("token错误，请登录");
        }
    }

}
