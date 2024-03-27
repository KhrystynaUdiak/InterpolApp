package com.example.springapp.service;

import com.example.springapp.model.Offender;

import java.util.List;

public interface OffenderService {
    Offender create(Offender offender);
    Offender readById(long id);
    Offender update(Offender offender);
    void delete(long id);
    List<Offender> getAll();

    List<Offender> getByCriteria(String firstName, String lastName, String alias, Integer minAge, Integer maxAge, String lastPlaceOfResidence, String keyword);
    boolean isDead(Offender offender);
}
