package com.carol.carolaicodeapp;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.carol.carolaicodemother.ai.config")
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.carol.carolaicodeapp.mapper")
@EnableCaching
public class CarolAiCodeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarolAiCodeAppApplication.class, args);
    }
}
