package org.example.domain.repositories;

import org.example.domain.model.FeedingSchedule;

import java.util.List;
import java.util.Optional;

public interface FeedingScheduleRepository {
    FeedingSchedule add(FeedingSchedule schedule);
    FeedingSchedule update(FeedingSchedule schedule);
    Optional<FeedingSchedule> findById(long id);
    List<FeedingSchedule> findAll();
    void delete(long id);

    List<FeedingSchedule> findByAnimalId(long animalId);
}
