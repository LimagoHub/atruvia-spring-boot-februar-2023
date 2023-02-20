package de.bankenit.simplespring.math;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("impl")
public class CalculatorImpl implements Calculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }
}
