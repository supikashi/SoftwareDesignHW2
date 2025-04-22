package org.example.infrastructure.persistence;

import org.example.domain.model.Animal;
import org.example.domain.repositories.AnimalRepository;
import org.example.domain.valueobjects.Species;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAnimalRepository implements AnimalRepository {
    private final List<Animal> animals = new ArrayList<>();
    private long nextId = 1;

    public InMemoryAnimalRepository() {

    }

    @Override
    public Animal add(Animal animal) {
        Animal newAnimal = new Animal(
                nextId++,
                animal.getSpecies(),
                animal.getName(),
                animal.getBirthDate(),
                animal.getGender(),
                animal.getFavoriteFood(),
                animal.getHealthStatus(),
                animal.getEnclosureId()
        );
        animals.add(newAnimal);
        return newAnimal;
    }

    @Override
    public Animal update(Animal animal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == animal.getId()) {
                animals.set(i, animal);
            }
        }
        return animal;
    }

    @Override
    public Optional<Animal> findById(long id) {
        return animals.stream().filter(it -> it.getId() == id).findFirst();
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(animals);
    }

    @Override
    public void delete(long id) {
        animals.removeIf(it -> it.getId() == id);
    }

    @Override
    public List<Animal> findBySpecies(Species species) {
        return animals.stream().filter(it -> it.getSpecies().equals(species)).toList();
    }

    @Override
    public List<Animal> findByEnclosureId(long enclosureId) {
        return animals.stream().filter(it -> it.getEnclosureId() == enclosureId).toList();
    }
}
