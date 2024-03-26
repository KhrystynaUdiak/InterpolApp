package com.example.springapp.repository;

import com.example.springapp.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
}