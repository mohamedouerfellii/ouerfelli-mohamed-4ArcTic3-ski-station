package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.repositories.SkierRepository;
import tn.esprit.atelier_1.services.ISkierService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkierService implements ISkierService {

    private final SkierRepository repository;

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
}
