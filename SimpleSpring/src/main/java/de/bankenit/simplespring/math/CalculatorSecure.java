package de.bankenit.simplespring.math;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
//@Qualifier("secure")
@Primary
@Profile("test")
public class CalculatorSecure implements Calculator{

    private final Calculator calculator;

    public CalculatorSecure(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double add(double a, double b) {
        System.out.println("Du kommst hier rein!");
        return calculator.add(a, b);
    }
}
