package de.bankenit.webapp.repository;

import de.bankenit.webapp.repository.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonenRepository extends CrudRepository<PersonEntity, UUID> {
    Iterable<PersonEntity> findByVorname(String vorname);
}
