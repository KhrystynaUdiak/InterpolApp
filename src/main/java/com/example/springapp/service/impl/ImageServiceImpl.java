package com.example.springapp.service.impl;

import com.example.springapp.model.Image;
import com.example.springapp.repository.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ImageServiceImpl {
    @Autowired
    private ImageRepository imageRepository;

    public List getAllImages(){
        return imageRepository.findAll();
    }
    public Image getImageById(Long id) {
        Optional<Image> optional = imageRepository.findById(id);
        return optional.get();
    }


    public void saveImage(Image image, MultipartFile file) {
        try {
            image.setImageData(file.getBytes());
            imageRepository.save(image);
        } catch (IOException ex) {
            
        }

    }
}
