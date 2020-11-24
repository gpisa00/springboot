package it.arteprogrammazione.springboot.calculator.service.impl;

import it.arteprogrammazione.springboot.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int diff(int a, int b){
        return a - b;
    }

    @Override
    public long mul(int a, int b){
        return a * b;
    }

    @Override
    public double div(int a, int b) throws ArithmeticException{
        return a / b ;
    }

}
