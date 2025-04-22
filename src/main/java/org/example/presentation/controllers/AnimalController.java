package org.example.presentation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.application.interfaces.AnimalService;
import org.example.application.interfaces.AnimalTransferService;
import org.example.domain.events.AnimalMovedEvent;
import org.example.domain.model.Animal;
import org.example.domain.valueobjects.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
@Tag(name = "Animal Management")
public class AnimalController {
    private final AnimalService animalService;
    private final AnimalTransferService animalTransferService;

    @Autowired
    public AnimalController(AnimalService animalService, AnimalTransferService animalTransferService) {
        this.animalService = animalService;
        this.animalTransferService = animalTransferService;
    }

    @PostMapping
    @Operation(summary = "Create new animal")
    public Animal createAnimal(@RequestBody Animal request) {
        return animalService.addAnimal(request);
    }

    @PutMapping
    @Operation(summary = "Update animal")
    public Animal updateAnimal(@RequestBody Animal request) {
        return animalService.updateAnimal(request);
    }

    @GetMapping
    @Operation(summary = "Get animals list")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get animal by ID")
    public Optional<Animal> getAnimal(@PathVariable long id) {
        return animalService.getAnimalById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete animal")
    public void deleteAnimal(@PathVariable long id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping("/{id}/move")
    @Operation(summary = "Move animal to another enclosure")
    public AnimalMovedEvent moveAnimal(
            @PathVariable long id,
            @RequestParam long enclosureId
    ) {
        return animalTransferService.transferAnimal(id, enclosureId, LocalDateTime.now());
    }

    @GetMapping("/{id}/by_enclosure")
    @Operation(summary = "getAllAnimalsByEnclosureId")
    public List<Animal> getAllAnimalsByEnclosureId(@PathVariable long id) {
        return animalService.getAllAnimalsByEnclosureId(id);
    }

    @GetMapping("/by_species")
    @Operation(summary = "getAllAnimalsBySpecies")
    public List<Animal> getAllAnimalsBySpecies(Species species) {
        return animalService.getAllAnimalsBySpecies(species);
    }
}
