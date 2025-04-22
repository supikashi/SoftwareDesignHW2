package org.example.application.interfaces;

import org.example.domain.events.FeedingTimeEvent;
import org.example.domain.model.FeedingSchedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FeedingOrganizationService {
    public Optional<FeedingSchedule> getScheduleById(long id);

    public List<FeedingSchedule> getScheduleList();

    public FeedingSchedule addFeedingSchedule(FeedingSchedule schedule);

    public FeedingSchedule updateFeedingSchedule(FeedingSchedule schedule);

    public void deleteFeedingSchedule(long id);

    public FeedingTimeEvent markFeedingCompleted(Long scheduleId, LocalDateTime now);
}
