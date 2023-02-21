package de.bankenit.webapp.service;

import de.bankenit.webapp.service.model.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonenService {

    boolean speichern(Person person) throws PersonenServiceException;
    boolean loesche(String id) throws PersonenServiceException;

    Optional<Person> findeNachId(String id) throws PersonenServiceException;

    Iterable<Person> findeAlle() throws PersonenServiceException;
}
