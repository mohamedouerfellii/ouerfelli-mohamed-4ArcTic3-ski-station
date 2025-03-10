package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Skier;

import java.util.List;

public interface ISkierService {
    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    void removeSkier (Long numSkier);
    Skier retrieveSkier (Long numSkier);
}
