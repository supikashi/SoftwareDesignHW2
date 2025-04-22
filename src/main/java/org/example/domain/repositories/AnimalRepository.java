package org.example.domain.repositories;

import org.example.domain.model.Animal;
import org.example.domain.valueobjects.Species;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal add(Animal animal);
    Animal update(Animal animal);
    Optional<Animal> findById(long id);
    List<Animal> findAll();
    void delete(long id);

    List<Animal> findBySpecies(Species species);
    List<Animal> findByEnclosureId(long enclosureId);
}