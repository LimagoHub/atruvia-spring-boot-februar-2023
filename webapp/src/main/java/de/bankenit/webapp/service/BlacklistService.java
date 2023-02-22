package de.bankenit.webapp.service;

import de.bankenit.webapp.service.model.Person;

public interface BlacklistService {

    boolean isBlacklisted(Person possibleBlacklistedPerson);
}
