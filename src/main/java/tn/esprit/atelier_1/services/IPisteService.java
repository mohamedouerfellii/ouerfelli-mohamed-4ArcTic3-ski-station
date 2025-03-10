package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Piste;
import tn.esprit.atelier_1.entity.Skier;

import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    Piste retrievePiste(Long numPiste);

    Piste assignSkierToPiste(Long numSkier, Long numPiste);
}
