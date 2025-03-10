package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Registration;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.repositories.RegistrationRepository;
import tn.esprit.atelier_1.repositories.SkierRepository;
import tn.esprit.atelier_1.services.IRegistrationService;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {

    private final RegistrationRepository repository;
    private final SkierRepository skierRepository;
    public Registration addRegistrationAndAssignToSkier(
            Registration registration, Long numSkieur
    ) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        if(skier != null)
            registration.setSkier(skier);
        return repository.save(registration);
    }
}
