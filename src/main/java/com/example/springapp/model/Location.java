package com.example.springapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "last_place_of_residence")
    private String lastPlaceOfResidence;

    @OneToMany(mappedBy = "location", orphanRemoval = true)
    private List<Offender> offender;

}
