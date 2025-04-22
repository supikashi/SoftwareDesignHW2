package org.example.domain.events;

import java.time.LocalDateTime;
import java.util.Objects;

public record AnimalMovedEvent(
        long animalId,
        long sourceEnclosureId,
        long targetEnclosureId,
        LocalDateTime timestamp
) implements DomainEvent {
    public AnimalMovedEvent {
        Objects.requireNonNull(timestamp, "Time stamp cannot be null");
    }

    @Override
    public String description() {
        return String.format("Animal %s moved from enclosure %s to enclosure %s",
                animalId, sourceEnclosureId, targetEnclosureId);
    }
}
