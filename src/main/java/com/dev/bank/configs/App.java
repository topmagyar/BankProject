package com.dev.bank.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

// UI(react, js, html, css) - REST API - Back-end(logic, converts) - DB

// config - config files
// controller - classes with endpoints (REST API)
// model - classes with base models
// service - logic
// db - convert base models into database records