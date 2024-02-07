package org.sakila.norbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public abstract class SakilaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SakilaApplication.class, args);
    }


  
}
