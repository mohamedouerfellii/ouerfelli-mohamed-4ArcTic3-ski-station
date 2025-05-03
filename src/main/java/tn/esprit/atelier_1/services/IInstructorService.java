package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Instructor;
import tn.esprit.atelier_1.enums.Support;

import java.util.List;

public interface IInstructorService {
    List<Instructor> retrieveInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (Long numInstructor);
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long
            numCourse);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor,
                                                      Support support);
}
