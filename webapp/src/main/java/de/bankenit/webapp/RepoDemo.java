package de.bankenit.webapp;


import de.bankenit.webapp.repository.PersonenRepository;
import de.bankenit.webapp.repository.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Component

@Transactional
public class RepoDemo {

    private final PersonenRepository repo;
    private final List<String> stadtLandFluss;

    public RepoDemo(PersonenRepository repo, @Qualifier("stadtLandFluss") List<String> stadtLandFluss) {
        this.repo = repo;
        this.stadtLandFluss = stadtLandFluss;
    }

    @PostConstruct
    public void foo() {

//        Iterable<PersonEntity> personen = repo.findByVorname("John");
//
//        personen.forEach(System.out::println);

 //       repo.save(PersonEntity.builder().id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build());

        System.out.println(stadtLandFluss);
    }
}
