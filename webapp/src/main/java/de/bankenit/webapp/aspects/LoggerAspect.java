package de.bankenit.webapp.aspects;


import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
public class LoggerAspect {




    @Before("Pointcuts.serviceMethods()")
    public void logAdvice(JoinPoint joinPoint) {
        log.warn(joinPoint.getSignature().getName() + " wurde gerufen");
    }

    @AfterReturning(
            value = "Pointcuts.personenQueryControllerMethods()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.warn(result.toString());
    }

    @AfterThrowing(
            value = "execution(public * de.bankenit.webapp.presentation.controller.personen.PersonenCommandController.*(..))",
            throwing = "ex"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error(ex.toString());
    }

    @After("Pointcuts.personenQueryControllerMethods()")
    public void after(JoinPoint joinPoint) {
        log.error(joinPoint.getSignature().getName());
    }

    @Around("Pointcuts.personenQueryControllerMethods()")
    public Object benchmarck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        var start = Instant.now();
        Object result = proceedingJoinPoint.proceed(); // Eigentliche Methode selbst ausführen
        var end = Instant.now();

        var duration = Duration.between(start,end);
        System.out.println("Duration = " + duration.toMillis());
        return result;
    }
}
