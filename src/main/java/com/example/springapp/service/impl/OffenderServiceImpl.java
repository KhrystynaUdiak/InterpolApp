package com.example.springapp.service.impl;

import com.example.springapp.model.Image;
import com.example.springapp.model.Offender;
import com.example.springapp.repository.OffenderRepository;
import com.example.springapp.service.OffenderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Transactional
@Service
public class OffenderServiceImpl implements OffenderService {
    @Autowired
    OffenderRepository offenderRepository;
    @Autowired
    ImageServiceImpl imageService;
    @Override
    @Transactional
    public Offender create(Offender offender, MultipartFile firstFile, MultipartFile secondFile) throws IOException {
        Image firstImage;
        Image secondImage;

        if(firstFile.getSize() !=0){
            firstImage = toImageEntity(firstFile);
            offender.addImageToOffender(firstImage);

        }
        if(secondFile.getSize() !=0){
            secondImage = toImageEntity(secondFile);
            offender.addImageToOffender(secondImage);;
        }
        return offenderRepository.save(offender);
    }

    private Image toImageEntity(MultipartFile file) throws IOException{
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(image.getOriginalFileName());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setImageData(file.getBytes());
        return image;
    }

    @Override
    public Offender readById(long id) {
        Optional<Offender> optional = offenderRepository.findById(id);
        return optional.get();
    }

    @Override
    public Offender update(Offender offender) {
        Offender oldOffender = readById(offender.getId());
        return offenderRepository.save(offender);
    }

    @Override
    public void delete(long id) {
       Offender offender = readById(id);
       if(isDead(offender)) {
           offenderRepository.delete(offender);
       }
    }

    @Override
    public List<Offender> getAll() {
        List<Offender> offenders = offenderRepository.findAll();
        return offenders.isEmpty() ? new ArrayList<>() : offenders;
    }


    @Override
    public List<Offender> getByCriteria(String firstName, String lastName, String alias, Integer minAge, Integer maxAge,
                                        String lastPlaceOfResidence, String keyword){
        List<Offender> offenders = offenderRepository.getByCriteria(firstName, lastName, alias, minAge, maxAge, lastPlaceOfResidence, keyword);
        return offenders.isEmpty() ? new ArrayList<>() : offenders;
    }
    @Override
   public boolean isDead(Offender offender){
        String deathDate = offender.getDeathDate();
        return deathDate != null && !deathDate.isEmpty();
    }
}
