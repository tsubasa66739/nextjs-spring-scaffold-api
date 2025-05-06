package com.example.spring_boot_trial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.spring_boot_trial.mapper")
public class SpringBootTrialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTrialApplication.class, args);
    }

}
