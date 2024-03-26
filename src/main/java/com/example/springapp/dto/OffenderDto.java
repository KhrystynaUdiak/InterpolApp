package com.example.springapp.dto;

import com.example.springapp.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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

//    private long descriptionId;
    private Description description;

//    private long locationId;
    private Location location;

//    private long criminalOrganizationId;
    private CriminalOrganization criminalOrganization;

    private List<Language> languages;

    private boolean archived;

    private String deathDate;
}
