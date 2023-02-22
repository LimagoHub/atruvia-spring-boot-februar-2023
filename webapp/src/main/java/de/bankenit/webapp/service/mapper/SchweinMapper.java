package de.bankenit.webapp.service.mapper;

import de.bankenit.webapp.repository.entities.SchweinEntity;
import de.bankenit.webapp.service.model.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinMapper {

    Schwein convert(SchweinEntity entity);
    SchweinEntity convert(Schwein schwein);

    Iterable<Schwein> convert(Iterable<SchweinEntity> entities);
}
