package it.arteprogrammazione.springboot.calculator;

import it.arteprogrammazione.springboot.calculator.enumeration.OperationEnum;
import it.arteprogrammazione.springboot.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Calculator {

    private final ICalculatorService calculatorService;
    private final Scanner scanner;

    @Autowired
    public Calculator(ICalculatorService calculatorService, Scanner scanner) {
        this.calculatorService = calculatorService;
        this.scanner = scanner;
    }

    public void startCalculator() {
        boolean started = false;

        while (true) {

            if (!started) {
                System.out.println("Avvio Applicazione Calculator...");
                started = true;
            } else {
                System.out.println("Esecuzione operazione successiva...");
            }

            OperationEnum operation = insertOperation();

            if (operation != null) {
                switch (operation) {
                    case MUL:
                        System.out.println("Result = " + calculatorService.mul(insertInput(), insertInput()));
                        break;
                    case SUM:
                        System.out.println("Result = " + calculatorService.sum(insertInput(), insertInput()));
                        break;
                    case DIFF:
                        System.out.println("Result = " + calculatorService.diff(insertInput(), insertInput()));
                        break;
                    case DIV:
                        try {
                            System.out.println("Result = " + calculatorService.div(insertInput(), insertInput()));
                        }catch (ArithmeticException e){
                            System.out.println("Divisione per 0  non consentita");
                        }
                        break;
                    case EXIT:
                        System.out.println("Spegnimento Applicazione...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Operazione non riconosciuta...Ritenta");
                        break;
                }
            }

        }

    }

    private OperationEnum insertOperation() {
        System.out.println("Che operazione vuoi eseguire? (SUM, MUL, DIFF, DIV, EXIT)");
        OperationEnum operation;

        while (true) {
            try {
                operation = OperationEnum.valueOf(scanner.nextLine());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Operazione non riconosciuta...Ritenta");
                continue;
            }
        }
        return operation;
    }

    private int insertInput() {
        int input;
        while (true) {
            try {
                System.out.println("Inserisci input:");
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Input inserito deve essere un numero...Ritenta");
            }
        }
        return input;
    }

}
