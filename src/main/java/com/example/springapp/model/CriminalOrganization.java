package com.example.springapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "criminal_organization")
public class CriminalOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "kind_of_accomplices")
    @Enumerated(EnumType.STRING)
    private Accomplices accomplices;

    @OneToMany(mappedBy = "criminalOrganization", orphanRemoval = true)
    private List<Offender> offenders;
}
