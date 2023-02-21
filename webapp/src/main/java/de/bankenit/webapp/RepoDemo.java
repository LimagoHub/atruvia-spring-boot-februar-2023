package de.bankenit.webapp;


import de.bankenit.webapp.repository.PersonenRepository;
import de.bankenit.webapp.repository.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.UUID;

//@Component
@AllArgsConstructor
@Transactional
public class RepoDemo {

    private final PersonenRepository repo;


    @PostConstruct
    public void foo() {

//        Iterable<PersonEntity> personen = repo.findByVorname("John");
//
//        personen.forEach(System.out::println);

        repo.save(PersonEntity.builder().id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build());

        System.out.println(repo.findById("88d6ded0-92ed-40f1-a341-b98a85c0212b").get());
    }
}
