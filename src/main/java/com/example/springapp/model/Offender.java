package com.example.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offenders")
public class Offender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "alias")
    private String alias;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "age")
    private int age;

    @Column(name = "citizenship")
    @Enumerated(EnumType.STRING)
    private Citizenship citizenship;

    @NotBlank(message = "Please fill the qualification of the crime according to Criminal Code")
    @Column(name = "criminal_case")
    private String criminalCase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id")
    private Description description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "criminal_organization_id")
    private CriminalOrganization criminalOrganization;

    @ManyToMany
    @JoinTable(name = "language_skills",
            joinColumns = @JoinColumn(name = "offender_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    @ToString.Exclude
    private List<Language> languages;

    @Column(name = "archived", nullable = false)
    private boolean archived;

    @Column
    private String deathDate;

    public void setAge(int age) {
        LocalDate birthDate = LocalDate.parse(this.birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.age = Period.between( birthDate, LocalDate.now()).getYears();
    }

    public int getAge() {
        this.setAge(age);
        return age;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Offender offender = (Offender) o;
        return getId() != null && Objects.equals(getId(), offender.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
