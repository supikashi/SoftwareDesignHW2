package org.example.infrastructure.persistence;

import org.example.domain.model.FeedingSchedule;
import org.example.domain.repositories.FeedingScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryFeedingScheduleRepository implements FeedingScheduleRepository {
    private final List<FeedingSchedule> schedules = new ArrayList<>();
    private long nextId = 1;

    public InMemoryFeedingScheduleRepository() {

    }
    @Override
    public FeedingSchedule add(FeedingSchedule schedule) {
        FeedingSchedule newSchedule = new FeedingSchedule(
                nextId++,
                schedule.getAnimalToFeedId(),
                schedule.getTime(),
                schedule.getFoodType()
        );
        schedules.add(newSchedule);
        return newSchedule;
    }

    @Override
    public FeedingSchedule update(FeedingSchedule schedule) {
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId() == schedule.getId()) {
                schedules.set(i, schedule);
            }
        }
        return schedule;
    }

    @Override
    public Optional<FeedingSchedule> findById(long id) {
        return schedules.stream().filter(it -> it.getId() == id).findFirst();
    }

    @Override
    public List<FeedingSchedule> findAll() {
        return new ArrayList<>(schedules);
    }

    @Override
    public void delete(long id) {
        schedules.removeIf(it -> it.getId() == id);
    }

    @Override
    public List<FeedingSchedule> findByAnimalId(long animalId) {
        return schedules.stream().filter(it -> it.getAnimalToFeedId() == animalId).toList();
    }
}
