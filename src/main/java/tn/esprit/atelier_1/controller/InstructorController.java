package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.atelier_1.services.IInstructorService;

@RestController
@RequestMapping("instructor")
@RequiredArgsConstructor
public class InstructorController {

    private IInstructorService instructorService;
    
}
