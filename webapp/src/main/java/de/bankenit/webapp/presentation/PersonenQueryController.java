package de.bankenit.webapp.presentation;

import de.bankenit.webapp.presentation.dto.PersonDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class PersonenQueryController {


    @ApiResponse(responseCode = "200", description = "Person wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden" )
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDto> findById(@PathVariable  UUID id) {
        if(id.equals(UUID.randomUUID()))
            return ResponseEntity.ok(PersonDto.builder().id(id).vorname("John").nachname("Doe").build());
        return ResponseEntity.notFound().build();
    }
    @ApiResponse(responseCode = "200", description = "Personenabfrage erfolgreich ausgeführt")
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @GetMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<PersonDto>> findeAlle(
            @RequestParam(required = false, defaultValue = "") String vorname,
            @RequestParam(required = false, defaultValue = "") String nachname ) {
        var liste = List.of(
                PersonDto.builder().id(UUID.randomUUID()).vorname("John").nachname("Doe").build(),
                PersonDto.builder().id(UUID.randomUUID()).vorname("John").nachname("Wayne").build(),
                PersonDto.builder().id(UUID.randomUUID()).vorname("John").nachname("Rambo").build(),
                PersonDto.builder().id(UUID.randomUUID()).vorname("John").nachname("Wick").build(),
                PersonDto.builder().id(UUID.randomUUID()).vorname("John").nachname("McClaine").build()
        );
        return ResponseEntity.ok(liste);
    }

}
