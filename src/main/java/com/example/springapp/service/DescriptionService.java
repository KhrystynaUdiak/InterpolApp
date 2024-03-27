package com.example.springapp.service;

import com.example.springapp.model.Description;

public interface DescriptionService {

    public Description readById(long id);

    public Description create(Description description);

}
