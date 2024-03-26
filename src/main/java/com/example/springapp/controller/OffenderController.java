package com.example.springapp.controller;

import com.example.springapp.dto.OffenderDto;
import com.example.springapp.dto.OffenderDtoTransformer;
import com.example.springapp.model.*;
import com.example.springapp.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/offenders")
public class OffenderController implements WebMvcConfigurer {

    @Autowired
    private OffenderService offenderService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CriminalOrganizationService criminalOrganizationService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }

    @GetMapping("/create")
    public String create(Model model){
      OffenderDto offender = new OffenderDto();

      model.addAttribute("offender", offender);
      model.addAttribute("citizenships", Citizenship.values());
      model.addAttribute("accomplices", Accomplices.values());
      model.addAttribute("languages", languageService.getAll());
      return "offender-create";
    }

    @PostMapping("/create")
    public String create(@Valid OffenderDto offenderDto, BindingResult bindingResult, @RequestParam("languages") List<Language> languages,Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Some values in the form are incorrect");
            return "offender-create";
        }

        Description description = descriptionService.create(offenderDto.getDescription());
        Location location = locationService.create(offenderDto.getLocation());
        CriminalOrganization criminalOrganization = criminalOrganizationService.create(offenderDto.getCriminalOrganization());

        Offender offender = OffenderDtoTransformer.convertToEntity(offenderDto, description, location, criminalOrganization, languages);
        offender = offenderService.create(offender);
        redirectAttributes.addFlashAttribute("message", "Successfully saved " + offender.getFirstName() + offender.getLastName());
        return "redirect:/offenders/" + offender.getId() + "/read";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable(("id"))Long id, RedirectAttributes redirectAttributes, Model model) {
        try{
            OffenderDto offenderDto = OffenderDtoTransformer.convertToDto(offenderService.readById(id));
            model.addAttribute("offender", offenderDto);
            model.addAttribute("archived", offenderDto.isArchived());
            return "/offender-info";
        }catch (NoSuchElementException e){
            redirectAttributes.addFlashAttribute("message", "Offender with ID "+id+" could not be found");
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable(("id"))Long id, Model model, RedirectAttributes redirectAttributes) {
        try{
            OffenderDto offenderDto = OffenderDtoTransformer.convertToDto(offenderService.readById(id));
            model.addAttribute("offender", offenderDto);
            model.addAttribute("citizenships", Citizenship.values());
            model.addAttribute("accomplices", Accomplices.values());
            model.addAttribute("languages", languageService.getAll());
            model.addAttribute("deathDate", offenderDto.getDeathDate());
            return "offender-update";
        }catch (NoSuchElementException e){
            redirectAttributes.addFlashAttribute("message", "User with ID "+id+" could not be found");
            return "redirect:/";
        }
    }
    @PostMapping("/{id}/update")
    public String update(@Valid OffenderDto offenderDto, BindingResult bindingResult, @RequestParam("languages") List<Language> languages,  Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Some values in the form are incorrect");
            return "offender-create";
        }
        Description description = descriptionService.readById(offenderDto.getDescription().getId());
        Location location = locationService.readById(offenderDto.getLocation().getId());
        CriminalOrganization criminalOrganization = criminalOrganizationService.readById(offenderDto.getCriminalOrganization().getId());

        Offender offender = OffenderDtoTransformer.convertToEntity(offenderDto, description, location, criminalOrganization, languages);
        offenderService.update(offender);
        redirectAttributes.addFlashAttribute("message", "Successfully update " + offender.getFirstName() + offender.getLastName());
        return "redirect:/offenders/" + offender.getId() + "/read";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(("id"))Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            offenderService.delete(id);
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("message", "Could not find offender with ID " + id);
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", "Offender " + offenderService.readById(id).getFirstName() + " " + offenderService.readById(id).getLastName() + " removed");
        return "redirect:/offenders/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<OffenderDto> offenders = offenderService.getAll().stream()
                .map(OffenderDtoTransformer::convertToDto).collect(Collectors.toList());
        model.addAttribute("offenders", offenders);
        return "offender-list";
    }

    @GetMapping("/filter")
    public String getByCriteria(Model model, String firstName, String lastName, String alias, Integer minAge, Integer maxAge,
                                String lastPlaceOfResidence, String keyword) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("alias", alias);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        model.addAttribute("lastPlaceOfResidence", lastPlaceOfResidence);
        model.addAttribute("keyword", keyword);
        return "offender-list";
    }

    @PostMapping("/filter")
    public String getByCriteria(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String alias,
                                @RequestParam @Nullable Integer minAge, @RequestParam @Nullable Integer maxAge, @RequestParam String lastPlaceOfResidence,
                                @RequestParam String keyWord, Model model) {
        List<OffenderDto> offenders =  offenderService.getByCriteria(firstName, lastName, alias, minAge, maxAge, lastPlaceOfResidence, keyWord)
                .stream()
                .map(OffenderDtoTransformer::convertToDto).toList();

        model.addAttribute("offenders", offenders);
        return "offender-list";
    }
}
