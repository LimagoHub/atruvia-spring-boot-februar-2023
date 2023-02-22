package de.bankenit.webapp.service;


import de.bankenit.webapp.repository.PersonenRepository;
import de.bankenit.webapp.service.internal.PersonenServiceImpl;
import de.bankenit.webapp.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
public class PersonenServiceConfig {

    @Bean
    @Qualifier("antipathen")
    public List<String> antipathen() {
        return List.of("Attila","Peter","Paul","Mary");
    }

    @Bean
    @Qualifier("fruits")
    public List<String> createFruits() {
        return List.of("Banana","Apple","Cherry","Raspberry");
    }

//    @Bean()
//    @Scope("singleton")
//    @Lazy
//    public PersonenService createPersonenService(PersonenRepository repo, PersonMapper mapper, @Qualifier("antipathen") List<String> antipathen) {
//        return new PersonenServiceImpl(repo, mapper,antipathen);
//    }
}
