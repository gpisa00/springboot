package it.arteprogrammazione.springboot.cli;

import it.arteprogrammazione.springboot.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandAppRunner implements CommandLineRunner {

    @Autowired
    private Calculator calculator;

    @Override
    public void run(String... args) throws Exception {
        calculator.startCalculator();
    }
}
