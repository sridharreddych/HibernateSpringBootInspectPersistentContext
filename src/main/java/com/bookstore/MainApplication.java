package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    
    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }        

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.sqlOperations();
        };
    }
}
/*
 * Inspect Persistent Context

Description: This application is a sample of inspecting the Persistent Context content via org.hibernate.engine.spi.PersistenceContext.

Key points:

get the current Persistent Context via Hibernate SharedSessionContractImplementor
rely on PersistenceContext API
 * 
 */
