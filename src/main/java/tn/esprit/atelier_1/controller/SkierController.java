package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.atelier_1.entity.Skier;
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

    @GetMapping("get-one-skier")
    public Skier getSkier(@RequestParam Long numSkier) {
        return skierService.retrieveSkier(numSkier);
    }

    @DeleteMapping("delete-skier")
    public ResponseEntity<String> deleteSkier(@RequestParam Long numSkier) {
        skierService.removeSkier(numSkier);
        return ResponseEntity.ok().body("Skier deleted successfully");
    }

    @PostMapping("add-skier-course/{numCourse}")
    public Skier addSkierAndAssignToCourse(
            @RequestBody  Skier skier, @PathVariable(name = "numCourse") Long numCourse
    ){
        return skierService.addSkierAndAssignToCourse(skier, numCourse);
    }

}
