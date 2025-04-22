package org.example.domain.events;

import java.time.LocalDateTime;
import java.util.Objects;

public record FeedingTimeEvent(
        long scheduleId,
        LocalDateTime timestamp
) implements DomainEvent {
    public FeedingTimeEvent {
        Objects.requireNonNull(timestamp, "Time stamp cannot be null");
    }

    @Override
    public String description() {
        return "Feeding time event " + scheduleId;
    }
}