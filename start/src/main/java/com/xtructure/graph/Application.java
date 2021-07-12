package com.xtructure.graph;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * 项目启动类
 */
@Slf4j
@EnableAsync
@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.xtructure.graph", "com.alibaba.cola"})
@PropertySource(value = {
        "classpath:db.properties",
        "classpath:redis.properties"
        }, encoding = "UTF-8")
@MapperScan("com.xtructure.graph.customer")
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("项目启动成功!");
    }
}
