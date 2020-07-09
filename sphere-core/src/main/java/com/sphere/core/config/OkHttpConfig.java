package com.sphere.core.config;


import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author fly
 * @date 2019/7/19 19:34
 * desc:
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                // 连接超时
                .connectTimeout(30, TimeUnit.SECONDS)
                // 响应超时
                .readTimeout(30, TimeUnit.SECONDS)
                // 写超时
                .writeTimeout(30, TimeUnit.SECONDS)
                // 是否自动重连
                .retryOnConnectionFailure(true)
                // 连接池
                .connectionPool(new ConnectionPool())
                .build();
    }
}
