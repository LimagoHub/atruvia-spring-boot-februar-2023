package de.bankenit.webapp.repository;


import de.bankenit.webapp.repository.entities.SchweinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SchweinRepository extends CrudRepository<SchweinEntity, String> {


    // Http Verb Patch
    @Query("update SchweinEntity s set s.gewicht=:gewicht where s.id=:id")
    void neuesGewicht(String id, int gewicht);
}
