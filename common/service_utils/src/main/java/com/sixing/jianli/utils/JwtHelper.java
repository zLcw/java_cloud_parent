package com.sixing.jianli.utils;

import com.sixing.jianli.constant.RedisKey;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

public class JwtHelper {


    //根据userid  和  username 生成token字符串
    public static String createToken(String userId, String userName) {
        String token = Jwts.builder()
                //设置token分类
                .setSubject("GGKT-USER")
                //token字符串有效时长
                .setExpiration(new Date(System.currentTimeMillis() + RedisKey.REDIS_KEY_EXPIRE))
                //私有部分（用户信息）
                .claim("userId", userId)
                .claim("userName", userName)
                //根据秘钥使用加密编码方式进行加密，对字符串压缩
                .signWith(SignatureAlgorithm.HS512, RedisKey.TOKEN_SECRET_KEY)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //从token字符串获取userid
    public static String getUserId(String token) {
        if(StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(RedisKey.TOKEN_SECRET_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("userId");
    }

    //从token字符串获取getUserName
    public static String getUserName(String token) {
        if(StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws
                = Jwts.parser().setSigningKey(RedisKey.TOKEN_SECRET_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("userName");
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken("123456", "231231232312");
        System.out.println(token);
        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUserName(token));
    }
}