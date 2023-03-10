package com.government.government;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class GovernmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(GovernmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            log.info("------------------*-------------------------");
            log.info("|                                           |");
            log.info("|  Local Government API Application         |");
            log.info("|                                           |");
            log.info("------------------*-------------------------");
        };
    }
}
