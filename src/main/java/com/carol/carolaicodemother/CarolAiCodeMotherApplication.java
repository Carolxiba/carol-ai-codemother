package com.carol.carolaicodemother;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.carol.carolaicodemother.mapper")
public class CarolAiCodeMotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarolAiCodeMotherApplication.class, args);
    }

}
