package com.example.springapp.service;

import com.example.springapp.model.Description;
import com.example.springapp.model.Offender;

public interface DescriptionService {

    public Description readById(long id);

    Description create(Description description);

}
