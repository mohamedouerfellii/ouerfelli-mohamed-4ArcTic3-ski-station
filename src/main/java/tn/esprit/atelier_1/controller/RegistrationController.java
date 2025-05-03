package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.atelier_1.entity.Registration;
import tn.esprit.atelier_1.services.IRegistrationService;

@RestController
@RequestMapping("registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final IRegistrationService registrationService;

    @PostMapping("add-registration/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(
            @RequestBody Registration registration,
            @PathVariable(name = "numSkier") Long numSkier
    ) {
        return registrationService.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PatchMapping("assign-registration-to-course/{numRegistration}/{numCourse}")
    public Registration addRegistrationAndAssignToSkier(
            @PathVariable(name = "numRegistration") Long numRegistration,
            @PathVariable(name = "numCourse") Long numCourse
    ) {
        return registrationService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("add-registration-assign-skier-course/{numSkier}/{numCourse}")
    public Registration addRegistrationAndAssignToSkierAndCourse(
            @RequestBody Registration registration,
            @PathVariable("numSkier") Long numSkier,
            @PathVariable("numCourse") Long numCourse
    ) {
        return registrationService.addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);
    }
}
