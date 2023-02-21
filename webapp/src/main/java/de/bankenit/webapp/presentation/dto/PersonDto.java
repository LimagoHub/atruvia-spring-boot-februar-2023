package de.bankenit.webapp.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class PersonDto { // Technisches Objekt

    @NotNull
    private UUID id;
    @NotNull
    @Size(min=2, max=30)
    private String vorname;
    @NotNull
    @Size(min=2, max=30)
    private String nachname;
}
