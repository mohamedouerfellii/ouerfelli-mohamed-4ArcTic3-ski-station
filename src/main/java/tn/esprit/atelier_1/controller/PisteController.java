package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.atelier_1.entity.Piste;
import tn.esprit.atelier_1.services.IPisteService;

@RestController
@RequestMapping("piste")
@RequiredArgsConstructor
public class PisteController {

    private final IPisteService pisteService;




    @PatchMapping("assign-skier-to-piste")
    public Piste assignSkierToPiste(
            @RequestParam Long numSkier,
            @RequestParam Long numPiste
    ) {
        return pisteService.assignSkierToPiste(numSkier, numPiste);
    }
}
