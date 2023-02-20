package de.bankenit.simplespring;

import de.bankenit.simplespring.math.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Profile("test")
public class OtherRunner implements CommandLineRunner {


    private final Calculator calculator;

    public OtherRunner(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(calculator.add(3,4));
    }
}
