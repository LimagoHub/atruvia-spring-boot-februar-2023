package de.bankenit.simplespring.math;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("logger")
@Primary
@Profile("production")
public class CalculatorLogger implements Calculator{

    private final Calculator calculator;

    public CalculatorLogger(Calculator calculator) {
        this.calculator = calculator;
    }

    public double add(double a, double b) {
        System.out.println("Add wurde gerufen");
        return calculator.add(a, b);
    }
}
