package com.example.springapp.service.impl;

import com.example.springapp.model.Description;
import com.example.springapp.repository.DescriptionRepository;
import com.example.springapp.service.DescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DescriptionServiceImpl implements DescriptionService {
    @Autowired
    DescriptionRepository descriptionRepository;
    @Override
    public Description readById(long id) {
        Optional<Description> optional = descriptionRepository.findById(id);
        return optional.get();
    }

    @Override
    public Description create(Description description) {
        return descriptionRepository.save(description);
    }
}
