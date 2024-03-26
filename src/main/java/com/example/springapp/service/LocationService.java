package com.example.springapp.service;

import com.example.springapp.model.Location;

public interface LocationService {

    public Location readById(long id);

    Location create(Location location);
}
