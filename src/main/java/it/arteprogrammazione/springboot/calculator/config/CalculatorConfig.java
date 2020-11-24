package it.arteprogrammazione.springboot.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class CalculatorConfig {

    @Bean
    public Scanner getScanner(){
        return new Scanner(System.in);
    }


}