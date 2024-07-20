package com.example.springapp.dto;

import com.example.springapp.model.*;

import java.util.List;

public class OffenderDtoTransformer {
    public static OffenderDto convertToDto(Offender offender){
        return new OffenderDto(
          offender.getId(),
                offender.getFirstName(),
                offender.getLastName(),
                offender.getAlias(),
                offender.getBirthdate(),
                offender.getAge(),
                offender.getCitizenship().toString(),
                offender.getCriminalCase(),
                offender.getDescription(),
                offender.getLocation(),
                offender.getCriminalOrganization(),
                offender.getLanguages(),
                offender.getImages(),
                offender.isArchived(),
                offender.getDeathDate());
    }

    public static Offender convertToEntity(OffenderDto offenderDto, Description description, Location location, CriminalOrganization criminalOrganization, List<Language> languages){
        Offender offender = new Offender();
        offender.setId(offenderDto.getId());
        offender.setFirstName(offenderDto.getFirstName());
        offender.setLastName(offenderDto.getLastName());
        offender.setAlias(offenderDto.getAlias());
        offender.setBirthdate(offenderDto.getBirthdate());
        offender.setAge(offenderDto.getAge());
        offender.setCitizenship(Citizenship.valueOf(offenderDto.getCitizenship()));
        offender.setCriminalCase(offenderDto.getCriminalCase());
        offender.setDescription(description);
        offender.setLocation(location);
        offender.setCriminalOrganization(criminalOrganization);
        offender.setLanguages(languages);
        offender.setDeathDate(offenderDto.getDeathDate());
//        offender.setImages(offenderDto.getImages());
        offender.setArchived(offenderDto.isArchived());
        return offender;
    }
}
