package com.example.springapp.service.impl;

import com.example.springapp.model.Location;
import com.example.springapp.repository.LocationRepository;
import com.example.springapp.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public Location readById(long id) {
        Optional<Location> optional = locationRepository.findById(id);
        return optional.get();
    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }
}
