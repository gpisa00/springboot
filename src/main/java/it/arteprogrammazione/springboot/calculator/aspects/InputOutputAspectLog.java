package it.arteprogrammazione.springboot.calculator.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class InputOutputAspectLog {

    private final Logger logger = LoggerFactory.getLogger(InputOutputAspectLog.class);

    @Pointcut("execution(* it.arteprogrammazione.springboot.calculator.service.ICalculatorService.*(..))")
    public void calculatorServiceMethods() {
    }

    @Before("calculatorServiceMethods()")
    public void beforeServiceExecution(JoinPoint joinPoint) {
        logger.info("INIZIO - Esecuzione metodo: " + joinPoint.getSignature().getName());
        for (Object o : joinPoint.getArgs()) {
            logger.info("INPUT : " + o.toString());
        }
    }

    @AfterReturning(value = "calculatorServiceMethods()", returning = "result")
    public void afterServiceExecution(JoinPoint joinPoint, Object result) {
        logger.info("RESULT : " + result.toString());
        logger.info("FINE - Esecuzione metodo: " + joinPoint.getSignature().getName());
    }

}
