package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Piste;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.enums.TypeSubscription;

import java.util.List;

public interface ISkierService {
    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    void removeSkier (Long numSkier);
    Skier retrieveSkier (Long numSkier);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
    Skier assignSkierToPiste(Long numSkier, Long numPiste);
    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);
}
