package com.performance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class App 
{
    public static void main(String[] args) {
        log.info("\n\n" +
                "----------------------------------------------------------------\n" +
                "  " + " - S T A R T ...\n" +
                "----------------------------------------------------------------\n");
        SpringApplication.run(App.class);
        log.info("\n\n" +
                "----------------------------------------------------------------\n" +
                "  " + " - S T A R T E D ! \n" +
                "----------------------------------------------------------------\n");

    }
}
