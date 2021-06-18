package com.example.kcell_gradle.repository;

import com.example.kcell_gradle.models.Affairs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
        CommandLineRunner initDatabase(AffairsRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Affairs("WorkOut","At morning", LocalDate.now())));
            log.info("Preloading " + repository.save(new Affairs("Reading","50 pages per day",LocalDate.now().plusDays(2))));
            log.info("Preloading " + repository.save(new Affairs("Sleeping","20 pages per day",LocalDate.now().plusDays(3))));
            log.info("Preloading " + repository.save(new Affairs("Running","30 pages per day",LocalDate.now().plusDays(4))));
            log.info("Preloading " + repository.save(new Affairs("Riding","40 pages per day",LocalDate.now().plusDays(5))));
            log.info("Preloading " + repository.save(new Affairs("Cleaning","50 pages per day",LocalDate.now().plusDays(6))));
            log.info("Preloading " + repository.save(new Affairs("Posting","70 pages per day",LocalDate.now().plusDays(7))));
            log.info("Preloading " + repository.save(new Affairs("Changing","80 pages per day",LocalDate.now().plusDays(8))));
        };


    }


}
