package it.arteprogrammazione.springboot.calculator.service;

import it.arteprogrammazione.springboot.calculator.aspects.InputOutputAspectLog;
import it.arteprogrammazione.springboot.calculator.service.impl.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = {CalculatorService.class})
public class CalculatorServiceTests {

    @Autowired
    private ICalculatorService calculatorService;

    @Test
    public void sumTest() {
        int a = 1;
        int b = 2;
        assertEquals(calculatorService.sum(a, b), 3);
    }

    @Test
    public void mulTest() {
        int a = 1;
        int b = 2;
        assertEquals(calculatorService.mul(a, b), 2);
    }

    @Test
    public void diffTest() {
        int a = 1;
        int b = 2;
        assertEquals(calculatorService.diff(a, b), -1);
    }

    @Test
    public void divTest() {
        int a = 2;
        int b = 2;
        assertEquals(calculatorService.div(a, b), 1);
    }

    @Test
    public void divExceptionTest() {
        int a = 2;
        int b = 0;
        assertThrows(RuntimeException.class, () -> {
            calculatorService.div(a, b);
        });
    }
}
