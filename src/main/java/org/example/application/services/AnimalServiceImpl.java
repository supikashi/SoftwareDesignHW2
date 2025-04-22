package org.example.application.services;

import org.example.application.interfaces.AnimalService;
import org.example.domain.model.Animal;
import org.example.domain.model.Enclosure;
import org.example.domain.repositories.AnimalRepository;
import org.example.domain.repositories.EnclosureRepository;
import org.example.domain.valueobjects.Species;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final EnclosureRepository enclosureRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository, EnclosureRepository enclosureRepository) {
        this.animalRepository = animalRepository;
        this.enclosureRepository = enclosureRepository;
    }

    @Override
    public Optional<Animal> getAnimalById(long id) {
        return animalRepository.findById(id);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getAllAnimalsByEnclosureId(long enclosureId) {
        return animalRepository.findByEnclosureId(enclosureId);
    }

    @Override
    public List<Animal> getAllAnimalsBySpecies(Species species) {
        return animalRepository.findBySpecies(species);
    }

    @Override
    public Animal addAnimal(Animal animal) {
        Optional<Enclosure> enclosure = enclosureRepository.findById(animal.getEnclosureId());
        if (enclosure.isPresent()) {
            enclosure.get().addAnimal();
            enclosureRepository.update(enclosure.get());
        }
        return animalRepository.add(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return animalRepository.update(animal);
    }

    @Override
    public void deleteAnimal(long id) {
        animalRepository.delete(id);
    }
}
