package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Instructor;

import java.util.List;

public interface IInstructorService {
    List<Instructor> retrieveInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (Long numInstructor);
}
