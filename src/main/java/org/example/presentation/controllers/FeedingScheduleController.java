package org.example.presentation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.application.interfaces.FeedingOrganizationService;
import org.example.domain.model.FeedingSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule")
@Tag(name = "Feeding Schedule Management")
public class FeedingScheduleController {
    private final FeedingOrganizationService feedingOrganizationService;
    @Autowired
    public FeedingScheduleController(FeedingOrganizationService feedingOrganizationService) {
        this.feedingOrganizationService = feedingOrganizationService;
    }

    @PostMapping
    @Operation(summary = "Create new schedule")
    public FeedingSchedule createSchedule(@RequestBody FeedingSchedule request) {
        return feedingOrganizationService.addFeedingSchedule(request);
    }

    @PutMapping
    @Operation(summary = "Update schedule")
    public FeedingSchedule updateSchedule(@RequestBody FeedingSchedule request) {
        return feedingOrganizationService.updateFeedingSchedule(request);
    }

    @GetMapping
    @Operation(summary = "Get schedules list")
    public List<FeedingSchedule> getAllSchedules() {
        return feedingOrganizationService.getScheduleList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get schedule by ID")
    public Optional<FeedingSchedule> getSchedule(@PathVariable long id) {
        return feedingOrganizationService.getScheduleById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete schedule")
    public void deleteSchedule(@PathVariable long id) {
        feedingOrganizationService.deleteFeedingSchedule(id);
    }

    @PutMapping("/{id}/feed")
    @Operation(summary = "Mark feeding completed")
    public void markFeedingCompleted(@PathVariable long id) {
        feedingOrganizationService.markFeedingCompleted(id, LocalDateTime.now());
    }
}
