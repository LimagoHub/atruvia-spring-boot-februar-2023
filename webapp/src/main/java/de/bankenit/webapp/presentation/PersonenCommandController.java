package de.bankenit.webapp.presentation;

import de.bankenit.webapp.presentation.dto.PersonDto;
import de.bankenit.webapp.presentation.mapper.PersonDtoMapper;
import de.bankenit.webapp.service.PersonenService;
import de.bankenit.webapp.service.PersonenServiceException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/personen")
@AllArgsConstructor
public class PersonenCommandController {

    private final PersonenService service;
    private final PersonDtoMapper mapper;

    @ApiResponse(responseCode = "200", description = "Person erfolgreich gelöscht")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden" )
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable  String id) throws PersonenServiceException {

        if(service.loesche(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrUpdate(@Valid @RequestBody PersonDto dto, UriComponentsBuilder builder) throws PersonenServiceException{
        // save
        UriComponents uriComponent = builder.path("/v1/personen/{id}").buildAndExpand(dto.getId());
        if(service.speichern(mapper.convert(dto)))
            return ResponseEntity.ok().build();
        return ResponseEntity.created(uriComponent.toUri()).build();
    }

//    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void>  update( @PathVariable String id, @Valid @RequestBody PersonDto dto) {
//        if(! id.equals(dto.getId()))
//            throw new IllegalArgumentException("Id im Pfad stimmt nicht mit mit Id in der Person ueberein");
//
//        return ResponseEntity.ok().build();
//    }
}
