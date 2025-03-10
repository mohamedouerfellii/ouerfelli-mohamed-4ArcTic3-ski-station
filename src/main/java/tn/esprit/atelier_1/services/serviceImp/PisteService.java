package tn.esprit.atelier_1.services.serviceImp;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Piste;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.repositories.PisteRepository;
import tn.esprit.atelier_1.repositories.SkierRepository;
import tn.esprit.atelier_1.services.IPisteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteService implements IPisteService {

    private final PisteRepository repository;
    private final SkierRepository skierRepository;

    public List<Piste> retrieveAllPistes() {
        return repository.findAll();
    }
    public Piste addPiste(Piste piste) {
        return repository.save(piste);
    }
    public Piste updatePiste (Piste piste) {
        return repository.save(piste);
    }
    public Piste retrievePiste (Long numPiste) {
        return repository.findById(numPiste).orElse(null);
    }

    public Piste assignSkierToPiste(Long numSkier, Long numPiste) {
        Piste piste = repository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        if(piste != null && skier != null) {
            piste.getSkiers().add(skier);
            return repository.save(piste);
        }
        return null;
    }
}
