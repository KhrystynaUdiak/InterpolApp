package com.example.springapp.service.impl;

import com.example.springapp.model.Offender;
import com.example.springapp.repository.OffenderRepository;
import com.example.springapp.service.OffenderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OffenderServiceImpl implements OffenderService {
    @Autowired
    OffenderRepository offenderRepository;
    @Override
    public Offender create(Offender offender) {
        return offenderRepository.save(offender);
    }

    @Override
    public Offender readById(long id) {
        Optional<Offender> optional = offenderRepository.findById(id);
        return optional.get();
    }

    @Override
    public Offender update(Offender offender) {
        Offender oldOffender = readById(offender.getId());
        return offenderRepository.save(offender);
    }

    @Override
    public void delete(long id) {
       Offender offender = readById(id);
       if(isDead(offender)) {
           offenderRepository.delete(offender);
       }
    }

    @Override
    public List<Offender> getAll() {
        List<Offender> offenders = offenderRepository.findAll();
        return offenders.isEmpty() ? new ArrayList<>() : offenders;
    }


    @Override
    public List<Offender> getByCriteria(String firstName, String lastName, String alias, Integer minAge, Integer maxAge,
                                        String lastPlaceOfResidence, String keyword){
        List<Offender> offenders = offenderRepository.getByCriteria(firstName, lastName, alias, minAge, maxAge, lastPlaceOfResidence, keyword);
        return offenders.isEmpty() ? new ArrayList<>() : offenders;
    }
    @Override
   public boolean isDead(Offender offender){
        String deathDate = offender.getDeathDate();
        return deathDate != null && !deathDate.isEmpty();
    }
}
