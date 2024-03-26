package com.example.springapp.controller;

import com.example.springapp.dto.OffenderDto;
import com.example.springapp.dto.OffenderDtoTransformer;
import com.example.springapp.service.OffenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    OffenderService offenderService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        List<OffenderDto> offenders = offenderService.getAll().stream()
                .map(OffenderDtoTransformer::convertToDto).collect(Collectors.toList());
        model.addAttribute("offenders", offenders);
        return "home";
    }
}
