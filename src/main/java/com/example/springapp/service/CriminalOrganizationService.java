package com.example.springapp.service;

import com.example.springapp.model.CriminalOrganization;

public interface CriminalOrganizationService {

    public CriminalOrganization readById(long id);

    CriminalOrganization create(CriminalOrganization criminalOrganization);
}
