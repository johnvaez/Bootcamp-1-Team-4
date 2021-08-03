package com.scotiabank;

import com.scotiabank.model.BlacklistEntity;
import com.scotiabank.repository.BlacklistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.scotiabank.model")
@EnableJpaRepositories("com.scotiabank.repository")
public class ScotiabankApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScotiabankApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BlacklistRepository blacklistRepository){
        return args -> {
            BlacklistEntity blacklistEntity  = new BlacklistEntity(1L, "1072422473");
            blacklistRepository.save(blacklistEntity);
        };
    }

}
