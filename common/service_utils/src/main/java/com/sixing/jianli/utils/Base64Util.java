package com.sixing.jianli.utils;

import lombok.SneakyThrows;

import java.util.Base64;

public class Base64Util {
    /**
     * 使用Base64进行加密
     * @param content 密文
     * @return
     */
    @SneakyThrows
    public static String base64Encode(String content) {
        return Base64.getEncoder().encodeToString(content.getBytes("UTF-8"));
    }

    /**
     * 使用Base64进行解密
     * @param content
     * @return
     */
    @SneakyThrows
    public static String base64Decode(String content) {
        return new String(Base64.getDecoder().decode(content), "UTF-8");
    }

}
