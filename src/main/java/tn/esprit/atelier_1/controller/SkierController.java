package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.enums.TypeSubscription;
import tn.esprit.atelier_1.services.ISkierService;

import java.util.List;

@RestController
@RequestMapping("skier")
@RequiredArgsConstructor
public class SkierController {
    private final ISkierService skierService;

    @PostMapping("add-skier")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @GetMapping("get-all-skiers")
    public List<Skier> getAllSkiers() {
        return skierService.retrieveAllSkiers();
    }

    @GetMapping("get-one-skier/{numSkier}")
    public Skier getSkier(@PathVariable("numSkier") Long numSkier) {
        return skierService.retrieveSkier(numSkier);
    }

    @DeleteMapping("delete-skier/{numSkier}")
    public ResponseEntity<String> deleteSkier(@PathVariable("numSkier") Long numSkier) {
        skierService.removeSkier(numSkier);
        return ResponseEntity.ok().body("Skier deleted successfully");
    }

    @PostMapping("add-skier-course/{numCourse}")
    public Skier addSkierAndAssignToCourse(
            @RequestBody  Skier skier, @PathVariable(name = "numCourse") Long numCourse
    ){
        return skierService.addSkierAndAssignToCourse(skier, numCourse);
    }

    @PatchMapping("assign-skier-to-piste/{numSkier}/{numPiste}")
    public Skier assignSkierToPiste(
            @PathVariable("numSkier") Long numSkier,
            @PathVariable("numPiste") Long numPiste) {
        return skierService.assignSkierToPiste(numSkier, numPiste);
    }

    @GetMapping("get-skiers-by-subscription/{typeSubscription}")
    public List<Skier> retrieveSkiersBySubscriptionType(
            @PathVariable("typeSubscription") TypeSubscription typeSubscription
            ) {
        return skierService.retrieveSkiersBySubscriptionType(typeSubscription);
    }
}
