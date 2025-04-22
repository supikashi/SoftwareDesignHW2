package org.example.application.services;

import org.example.application.interfaces.FeedingOrganizationService;
import org.example.domain.events.FeedingTimeEvent;
import org.example.domain.exceptions.FeedingException;
import org.example.domain.model.FeedingSchedule;
import org.example.domain.repositories.FeedingScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeedingOrganizationServiceImpl implements FeedingOrganizationService {
    private final FeedingScheduleRepository scheduleRepository;

    public FeedingOrganizationServiceImpl(
            FeedingScheduleRepository scheduleRepository
    ) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Optional<FeedingSchedule> getScheduleById(long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<FeedingSchedule> getScheduleList() {
        return scheduleRepository.findAll();
    }

    @Override
    public FeedingSchedule addFeedingSchedule(FeedingSchedule schedule) {
        return scheduleRepository.add(schedule);
    }

    @Override
    public FeedingSchedule updateFeedingSchedule(FeedingSchedule schedule) {
        return scheduleRepository.update(schedule);
    }

    @Override
    public void deleteFeedingSchedule(long id) {
        scheduleRepository.delete(id);
    }

    @Override
    public FeedingTimeEvent markFeedingCompleted(Long scheduleId, LocalDateTime now) {
        FeedingSchedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new FeedingException("Schedule not found"));

        schedule.markAsCompleted(now);
        scheduleRepository.update(schedule);
        return new FeedingTimeEvent(schedule.getId(), now);
    }
}
