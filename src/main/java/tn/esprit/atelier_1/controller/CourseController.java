package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.atelier_1.services.ICourseService;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService service;
}
