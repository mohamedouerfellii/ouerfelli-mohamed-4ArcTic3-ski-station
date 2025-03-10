package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Course;
import tn.esprit.atelier_1.entity.Instructor;
import tn.esprit.atelier_1.repositories.CourseRepository;
import tn.esprit.atelier_1.repositories.InstructorRepository;
import tn.esprit.atelier_1.services.IInstructorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements IInstructorService {

    private final InstructorRepository repository;
    private final CourseRepository courseRepository;

    public List<Instructor> retrieveInstructors() {
        return repository.findAll();
    }
    public Instructor addInstructor(Instructor instructor) {
        return repository.save(instructor);
    }
    public Instructor updateInstructor (Instructor instructor) {
        return repository.save(instructor);
    }
    public Instructor retrieveInstructor (Long numInstructor) {
        return repository.findById(numInstructor).orElse(null);
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        if(course != null) {
            instructor.getCourses().add(course);
        }
        return repository.save(instructor);
    }
}
