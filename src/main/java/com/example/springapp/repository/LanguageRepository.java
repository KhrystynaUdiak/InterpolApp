package com.example.springapp.repository;

import com.example.springapp.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}