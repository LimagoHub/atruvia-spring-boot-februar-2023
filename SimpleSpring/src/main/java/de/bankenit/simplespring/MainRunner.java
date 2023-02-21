package de.bankenit.simplespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(10)
public class MainRunner implements CommandLineRunner {



    private final Demo demo;
    @Value("${MainRunner.message}")
    private String message="MyMessage";

    public MainRunner(final Demo demo) {
        this.demo = demo;
        System.out.println(message);
    }

    @PostConstruct
    private void foo() {
        System.out.println(message);
    }
//    @Autowired
//    public void setDemo(Demo demo) {
//        this.demo = demo;
//        System.out.println("SetDemo");
//    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hallo Welt");
    }
}
