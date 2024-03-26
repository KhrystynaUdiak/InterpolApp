package com.example.springapp.repository;

import com.example.springapp.model.CriminalOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalOrganizationRepository extends JpaRepository<CriminalOrganization, Long> {
}