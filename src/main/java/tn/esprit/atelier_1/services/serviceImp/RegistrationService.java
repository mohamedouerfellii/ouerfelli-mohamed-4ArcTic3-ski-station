package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Course;
import tn.esprit.atelier_1.entity.Registration;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.enums.TypeCourse;
import tn.esprit.atelier_1.repositories.CourseRepository;
import tn.esprit.atelier_1.repositories.RegistrationRepository;
import tn.esprit.atelier_1.repositories.SkierRepository;
import tn.esprit.atelier_1.services.IRegistrationService;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {

    private final RegistrationRepository repository;
    private final SkierRepository skierRepository;
    private final CourseRepository courseRepository;

    @Override
    public Registration addRegistrationAndAssignToSkier(
            Registration registration, Long numSkier
    ) {
        Skier skier = skierRepository.findById(numSkier).orElseThrow(
                () -> new IllegalArgumentException("Skier not found.")
        );
        registration.setSkier(skier);
        return repository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = repository.findById(numRegistration).orElseThrow(
                () -> new IllegalArgumentException("Registration not found")
        );
        Course course = courseRepository.findById(numCourse).orElseThrow(
                () -> new IllegalArgumentException("Course not found")
        );
        registration.setCourse(course);
        return repository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElseThrow(
                () -> new IllegalArgumentException("Skier not found.")
        );
        Course course = courseRepository.findById(numCourse).orElseThrow(
                () -> new IllegalArgumentException("Course not found")
        );
        if(course.getRegistrations().size() > 6)
            throw new RuntimeException("Number of registration by course exceeded.");
        if(course.getTypeCourse().equals(TypeCourse.COLLECTIVE_ADULT) ) {
            if(skier.getAge() < 18)
                throw new RuntimeException("Skier must be older then 18 to access adult courses.");
        } else if(course.getTypeCourse().equals(TypeCourse.COLLECTIVE_CHILDREN)) {
            if(skier.getAge() > 18)
                throw new RuntimeException("Skier must be younger then 18 to access children courses.");
        }
        registration.setCourse(course);
        registration.setSkier(skier);
        return repository.save(registration);
    }
}
