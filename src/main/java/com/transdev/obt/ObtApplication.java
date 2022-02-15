package com.transdev.obt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.transdev.obt.repositories")
@EntityScan("com.transdev.obt.models")
@SpringBootApplication
public class ObtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObtApplication.class, args);
    }

}
