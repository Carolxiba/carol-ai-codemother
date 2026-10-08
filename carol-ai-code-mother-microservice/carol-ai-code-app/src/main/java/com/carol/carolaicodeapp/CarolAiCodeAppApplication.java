package com.carol.carolaicodeapp;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.carol.carolaicodemother"
        ,"com.carol.carolaicodeapp"})
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.carol.carolaicodeapp.mapper")
@EnableCaching
@EnableDubbo
public class CarolAiCodeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarolAiCodeAppApplication.class, args);
    }
}
