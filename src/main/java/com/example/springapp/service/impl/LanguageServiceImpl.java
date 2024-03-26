package com.example.springapp.service.impl;

import com.example.springapp.model.Language;
import com.example.springapp.model.Offender;
import com.example.springapp.repository.LanguageRepository;
import com.example.springapp.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepository;


    public List<Language> getAll(){
        List<Language> languages = languageRepository.findAll();
        return languages.isEmpty() ? new ArrayList<>() : languages;
    }

}
