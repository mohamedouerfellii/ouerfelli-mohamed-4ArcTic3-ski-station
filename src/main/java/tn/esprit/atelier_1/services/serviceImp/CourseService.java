package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Course;
import tn.esprit.atelier_1.repositories.CourseRepository;
import tn.esprit.atelier_1.services.ICourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository repository;

    public List<Course> retrieveAllCourses() {
        return repository.findAll();
    }
    public Course addCourse(Course course) {
        return repository.save(course);
    }
    public Course updateCourse(Course course) {
        return repository.save(course);
    }
    public Course retrieveCourse(Long numCourse) {
        return repository.findById(numCourse).orElse(null);
    }

}
