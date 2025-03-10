package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Course;
import tn.esprit.atelier_1.entity.Registration;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.repositories.CourseRepository;
import tn.esprit.atelier_1.repositories.RegistrationRepository;
import tn.esprit.atelier_1.repositories.SkierRepository;
import tn.esprit.atelier_1.services.IRegistrationService;
import tn.esprit.atelier_1.services.ISkierService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkierService implements ISkierService {

    private final SkierRepository repository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;
    private final IRegistrationService registrationService;

    public List<Skier> retrieveAllSkiers() {
        return repository.findAll();
    }
    public Skier addSkier(Skier skier) {
        return repository.save(skier);
    }
    public void removeSkier (Long numSkier) {
        repository.deleteById(numSkier);
    }
    public Skier retrieveSkier (Long numSkier) {
        return repository.findById(numSkier).orElse(null);
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        skier.getRegistrations().forEach(r ->
                {
                    r.setCourse(course);
                    r.setSkier(skier);
                }
        );
        return repository.save(skier);
    }
}
