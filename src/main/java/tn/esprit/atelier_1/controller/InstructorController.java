package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.atelier_1.entity.Instructor;
import tn.esprit.atelier_1.services.IInstructorService;

@RestController
@RequestMapping("instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final IInstructorService instructorService;

    @PostMapping("add-instructor/{numCourse}")
    public Instructor addInstructorAndAssignToCourse(
            @RequestBody  Instructor instructor,
            @PathVariable(name = "numCourse") Long numCourse) {
        return instructorService.addInstructorAndAssignToCourse(instructor, numCourse);
    }
}
