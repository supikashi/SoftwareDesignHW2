package org.example.presentation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.application.interfaces.ZooStatisticsService;
import org.example.domain.model.Enclosure;
import org.example.domain.valueobjects.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
@Tag(name = "Zoo Statistics Management")
public class ZooStatisticsController {
    private final ZooStatisticsService zooStatisticsService;
    @Autowired
    public ZooStatisticsController(ZooStatisticsService zooStatisticsService) {
        this.zooStatisticsService = zooStatisticsService;
    }

    @GetMapping("/animals")
    @Operation(summary = "Get animal statistics")
    public List<Stats> getAnimalStatistics() {
        return zooStatisticsService.getAnimalStatistics().entrySet().stream().map(it -> {
            return new Stats(it.getKey(), it.getValue());
        }).toList();
    }

    @GetMapping("/enclosures")
    @Operation(summary = "Get available enclosures")
    public List<Enclosure> getAvailableEnclosures() {
        return zooStatisticsService.findAvailableEnclosures();
    }

    private record Stats(
            Species species,
            Long count
    ) {}
}
