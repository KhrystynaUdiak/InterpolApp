package com.example.springapp.service.impl;

import com.example.springapp.model.CriminalOrganization;
import com.example.springapp.model.Offender;
import com.example.springapp.repository.CriminalOrganizationRepository;
import com.example.springapp.service.CriminalOrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class CriminalOrganizationServiceImpl implements CriminalOrganizationService {
    @Autowired
    CriminalOrganizationRepository criminalOrganizationRepository;
    @Override
    public CriminalOrganization readById(long id) {
        Optional<CriminalOrganization> optional = criminalOrganizationRepository.findById(id);
        return optional.get();
    }

    @Override
    public CriminalOrganization create(CriminalOrganization criminalOrganization) {
        return criminalOrganizationRepository.save(criminalOrganization);
    }
}
