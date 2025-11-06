package com.exemplo.poc.app;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class PocAuditoriaApplication implements CommandLineRunner {

    private final ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(PocAuditoriaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Beans registrados no Spring Boot:");
        String[] beans = context.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

}