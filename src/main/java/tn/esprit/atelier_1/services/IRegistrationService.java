package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Registration;

public interface IRegistrationService {
    Registration addRegistrationAndAssignToSkier(
            Registration registration, Long numSkier
    );

    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);

    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration,
                                                          Long numSkier, Long numCourse);
}
