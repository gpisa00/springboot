package it.arteprogrammazione.springboot.calculator.service;

public interface ICalculatorService {

    int sum(int a, int b);

    int diff(int a, int b);

    long mul(int a, int b);

    double div(int a, int b) throws ArithmeticException;
}
