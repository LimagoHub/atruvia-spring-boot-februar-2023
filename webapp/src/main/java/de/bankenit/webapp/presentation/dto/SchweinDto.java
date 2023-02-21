package de.bankenit.webapp.presentation.dto;

import javax.validation.constraints.DecimalMin;

public class SchweinDto {

    private String id;
    private String name;

    @DecimalMin("10")
    private int gewicht;
}
