package com.sphere.web;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(
        exclude = DruidDataSourceAutoConfigure.class
)
@ComponentScan(
        basePackages = {
                "com.sphere.web",
                "com.sphere.mybatis",
                "com.sphere.core"
        }
)
//@EnableSwagger2Doc
public class SphereApplication {
        public static void main(String[] args) {
                SpringApplication.run(SphereApplication.class);
        }
}
