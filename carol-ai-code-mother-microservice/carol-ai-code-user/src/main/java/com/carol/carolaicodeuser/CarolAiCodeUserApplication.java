package com.carol.carolaicodeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.carol.carolaicodeuser.mapper")
@ComponentScan("com.carol")
public class CarolAiCodeUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarolAiCodeUserApplication.class, args);
    }
}
