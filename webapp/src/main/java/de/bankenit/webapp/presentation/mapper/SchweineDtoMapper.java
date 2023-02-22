package de.bankenit.webapp.presentation.mapper;

import de.bankenit.webapp.presentation.dto.SchweinDto;
import de.bankenit.webapp.service.model.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweineDtoMapper {

    SchweinDto convert(Schwein schwein);
    Schwein convert(SchweinDto dto);

    Iterable<SchweinDto> convert(Iterable<Schwein> schweine);
}
