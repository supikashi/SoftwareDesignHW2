package org.example.application.services;

import org.example.application.interfaces.AnimalTransferService;
import org.example.domain.events.AnimalMovedEvent;
import org.example.domain.exceptions.TransferException;
import org.example.domain.model.Animal;
import org.example.domain.model.Enclosure;
import org.example.domain.repositories.AnimalRepository;
import org.example.domain.repositories.EnclosureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnimalTransferServiceImpl implements AnimalTransferService {
    private final AnimalRepository animalRepository;
    private final EnclosureRepository enclosureRepository;

    public AnimalTransferServiceImpl(
            AnimalRepository animalRepository,
            EnclosureRepository enclosureRepository
    ) {
        this.animalRepository = animalRepository;
        this.enclosureRepository = enclosureRepository;
    }

    @Override
    public AnimalMovedEvent transferAnimal(long animalId, long newEnclosureId, LocalDateTime now) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new TransferException("Animal not found"));

        Enclosure currentEnclosure = enclosureRepository.findById(animal.getEnclosureId())
                .orElseThrow(() -> new TransferException("Current enclosure not found"));

        Enclosure newEnclosure = enclosureRepository.findById(newEnclosureId)
                .orElseThrow(() -> new TransferException("New enclosure not found"));

        validateTransfer(animal, currentEnclosure, newEnclosure);

        currentEnclosure.removeAnimal();
        newEnclosure.addAnimal();

        animal.move(newEnclosureId);

        animalRepository.update(animal);
        enclosureRepository.update(currentEnclosure);
        enclosureRepository.update(newEnclosure);

        return new AnimalMovedEvent(
                animal.getId(),
                currentEnclosure.getId(),
                newEnclosure.getId(),
                now
        );
    }

    private void validateTransfer(Animal animal, Enclosure current, Enclosure target) {
        if (current.getId() == target.getId()) {
            throw new TransferException("Animal already in target enclosure");
        }
        if (target.getType() != animal.getSpecies().type()) {
            throw new TransferException("Enclosure type mismatch");
        }
        if (target.getCurrentAnimals() == target.getMaxCapacity()) {
            throw new TransferException("Target enclosure is full");
        }
    }
}
