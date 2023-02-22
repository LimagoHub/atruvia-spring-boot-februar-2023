package de.bankenit.webapp.service.internal;

import de.bankenit.webapp.repository.PersonenRepository;
import de.bankenit.webapp.service.PersonenService;
import de.bankenit.webapp.service.PersonenServiceException;
import de.bankenit.webapp.service.mapper.PersonMapper;
import de.bankenit.webapp.service.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Transactional(rollbackFor = PersonenServiceException.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PersonenServiceImpl implements PersonenService {

    private final PersonenRepository repo;
    private final PersonMapper mapper;

    private final List<String> antipathen;



    @Override
    public boolean speichern(Person person) throws PersonenServiceException {
        try {
            if(person == null)
                throw new PersonenServiceException("Person darf nicht null sein");

            if(person.getVorname() == null || person.getVorname().length() < 2)
                throw new PersonenServiceException("Vorname zu kurz");

            if(person.getNachname() == null || person.getNachname().length() < 2)
                throw new PersonenServiceException("Nachname zu kurz");

            if(antipathen.contains(person.getVorname()))
                throw new PersonenServiceException("Antipath");

            boolean result = repo.existsById(person.getId()) ;

            repo.save(mapper.convert(person));

            return result;
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }

    @Override
    public boolean loesche(String id) throws PersonenServiceException {
        try {
            if(repo.existsById(id)) {
                repo.deleteById(id);
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public Optional<Person> findeNachId(String id) throws PersonenServiceException {
        try {
            return repo.findById(id).map(mapper::convert);
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }

    @Override
    public Iterable<Person> findeAlle() throws PersonenServiceException {
        try {
            return mapper.convert(repo.findAll());
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }
}
