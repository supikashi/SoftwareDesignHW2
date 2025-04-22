package org.example.application.interfaces;

import org.example.domain.model.Animal;
import org.example.domain.valueobjects.Species;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    public Optional<Animal> getAnimalById(long id);

    public List<Animal> getAllAnimals();

    public List<Animal> getAllAnimalsByEnclosureId(long enclosureId);

    public List<Animal> getAllAnimalsBySpecies(Species species);

    public Animal addAnimal(Animal animal);

    public Animal updateAnimal(Animal animal);

    public void deleteAnimal(long id);
}
