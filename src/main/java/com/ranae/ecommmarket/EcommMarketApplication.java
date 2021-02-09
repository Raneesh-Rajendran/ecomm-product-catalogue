package com.ranae.ecommmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EcommMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommMarketApplication.class, args);
    }


}

