package com.macquarie.niks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
 
@SpringBootApplication
@EnableScheduling
public class InterestRateCalculatorApp {
 
    public static void main(String[] args) {
        SpringApplication.run(InterestRateCalculatorApp.class, args);
    }
}