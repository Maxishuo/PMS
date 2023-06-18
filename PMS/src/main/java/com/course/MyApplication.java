package com.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot startup
 *
 */
 @SpringBootApplication()

@MapperScan("com.course.mapper")

class MyApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(MyApplication.class, args);
    }
}