package com.example.springapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "language")
    private String name;

    @ManyToMany
    @JoinTable(name = "language_skills",
    joinColumns = @JoinColumn(name = "language_id"),
    inverseJoinColumns = @JoinColumn(name = "offender_id"))
    private List<Offender> offenders;

}
