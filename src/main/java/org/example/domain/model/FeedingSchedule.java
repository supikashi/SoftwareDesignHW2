package org.example.domain.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FeedingSchedule {
    private final long id;
    private final long animalToFeedId;
    private LocalTime time;
    private final String foodType;
    private final List<LocalDateTime> completedFeedingTimes;

    public FeedingSchedule(
            long id,
            long animalToFeedId,
            LocalTime time,
            String foodType
    ) {
        this.id = id;
        this.animalToFeedId = animalToFeedId;
        this.time = Objects.requireNonNull(time, "Time cannot be null");
        this.foodType = Objects.requireNonNull(foodType, "Food type cannot be null");
        this.completedFeedingTimes = new ArrayList<>();
    }

    public void changeFeedingTime(LocalTime newTime) {
        this.time = Objects.requireNonNull(newTime, "Time cannot be null");
    }

    public void markAsCompleted(LocalDateTime dateTime) {
        completedFeedingTimes
                .add(Objects.requireNonNull(dateTime, "Time cannot be null"));
    }

    public long getId() { return id; }

    public long getAnimalToFeedId() { return animalToFeedId; }

    public LocalTime getTime() { return time; }

    public String getFoodType() { return foodType; }

    public List<LocalDateTime> getCompletedFeedingTimes() {
        return Collections.unmodifiableList(completedFeedingTimes);
    }
}
