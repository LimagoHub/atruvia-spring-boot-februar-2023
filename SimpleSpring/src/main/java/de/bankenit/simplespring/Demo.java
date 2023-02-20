package de.bankenit.simplespring;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Bei Bedarf erstellen
public class Demo {

    public Demo() {
        System.out.println("Ctor Demo");
    }
}
