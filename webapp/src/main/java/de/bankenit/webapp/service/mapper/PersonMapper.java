package de.bankenit.webapp.service.mapper;


import de.bankenit.webapp.repository.entities.PersonEntity;
import de.bankenit.webapp.service.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person convert(PersonEntity entity);
    PersonEntity convert(Person person);

    Iterable<Person> convert(Iterable<PersonEntity> entities);
}
