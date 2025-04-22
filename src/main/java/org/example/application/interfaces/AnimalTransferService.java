package org.example.application.interfaces;

import org.example.domain.events.AnimalMovedEvent;

import java.time.LocalDateTime;

public interface AnimalTransferService {
    public AnimalMovedEvent transferAnimal(long animalId, long newEnclosureId, LocalDateTime now);
}
