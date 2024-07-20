package com.example.springapp.service;

import com.example.springapp.model.Offender;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface OffenderService {
    Offender create(Offender offender, MultipartFile image, MultipartFile secondImage) throws IOException ;
    Offender readById(long id);
    Offender update(Offender offender);
    void delete(long id);
    List<Offender> getAll();

    List<Offender> getByCriteria(String firstName, String lastName, String alias, Integer minAge, Integer maxAge, String lastPlaceOfResidence, String keyword);
    boolean isDead(Offender offender);
}
