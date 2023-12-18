package com.sixing.jianli.constant;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-15 15:59
 * @description
 */
public interface RedisKey {

    /**
     * redis token key 前缀
     */
    public static final String REDIS_KEY_PREFIX = "JIAN_LI_APP_TOKEN::";

    public static final String TOKEN_SECRET_KEY = "fhaoifgniuwhgbiwbeif";

    /**
     * redis token 过期时间 10分钟
     */
    public static final Integer REDIS_KEY_EXPIRE = 24*60*60*1000;
}
