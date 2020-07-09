package com.sphere.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@MapperScan(basePackages = "com.sphere.mybatis.mapper")
@DependsOn( value = {"redisTemplate", "redisCacheTransfer"} )
public class DefaultMybatisPlusConfig {
    /**
     * @return 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


}
