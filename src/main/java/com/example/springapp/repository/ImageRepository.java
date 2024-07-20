package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Image;


@Repository
public interface ImageRepository  extends JpaRepository<Image, Long> {

}
