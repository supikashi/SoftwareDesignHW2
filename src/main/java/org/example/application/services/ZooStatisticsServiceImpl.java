package org.example.application.services;

import org.example.application.interfaces.ZooStatisticsService;
import org.example.domain.model.Animal;
import org.example.domain.model.Enclosure;
import org.example.domain.repositories.AnimalRepository;
import org.example.domain.repositories.EnclosureRepository;
import org.example.domain.valueobjects.Species;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ZooStatisticsServiceImpl implements ZooStatisticsService {
    private final AnimalRepository animalRepository;
    private final EnclosureRepository enclosureRepository;

    public ZooStatisticsServiceImpl(
            AnimalRepository animalRepository,
            EnclosureRepository enclosureRepository
    ) {
        this.animalRepository = animalRepository;
        this.enclosureRepository = enclosureRepository;
    }

    @Override
    public Map<Species, Long> getAnimalStatistics() {
        return animalRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Animal::getSpecies,
                        Collectors.counting()
                ));
    }

    @Override
    public List<Enclosure> findAvailableEnclosures() {
        return enclosureRepository.findAll().stream()
                .filter(e -> e.getMaxCapacity() != e.getCurrentAnimals())
                .collect(Collectors.toList());
    }
}
