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
public class PersonenCommandController {


    @ApiResponse(responseCode = "200", description = "Person erfolgreich gelöscht")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden" )
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable  UUID id) {
        return ResponseEntity.notFound().build();
    }


    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody PersonDto dto, UriComponentsBuilder builder) {
        // save
        UriComponents uriComponent = builder.path("/v1/personen/{id}").buildAndExpand(dto.getId());
        //ResponseEntity.noContent().build();
        return ResponseEntity.created(uriComponent.toUri()).build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>  update( @PathVariable String id, @Valid @RequestBody PersonDto dto) {
        if(! id.equals(dto.getId()))
            throw new IllegalArgumentException("Id im Pfad stimmt nicht mit mit Id in der Person ueberein");

        return ResponseEntity.ok().build();
    }
}
