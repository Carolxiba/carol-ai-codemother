package com.carol.carolaicodemother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.carol.carolaicodemother.mapper")
public class CarolAiCodeMotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarolAiCodeMotherApplication.class, args);
    }

}
