package de.bankenit.simplespring;




import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import java.beans.beancontext.BeanContext;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Demo {

    public Demo() {
        System.out.println("Ctor Demo");
    }

    @PostConstruct
    public void foo() {
        System.out.println("Foo");
    }


    @PreDestroy
    public void dispose() {
        System.out.println("Und tschuess");
    }
}
