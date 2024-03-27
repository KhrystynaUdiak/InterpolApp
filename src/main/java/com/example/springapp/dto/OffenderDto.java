package com.example.springapp.dto;

import com.example.springapp.model.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OffenderDto {
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String alias;

    private String birthdate;

    private int age;

    private String citizenship;

    @NotNull
    private String criminalCase;

    private Description description;

    private Location location;

    private CriminalOrganization criminalOrganization;

    private List<Language> languages;

    private boolean archived;

    private String deathDate;
}
