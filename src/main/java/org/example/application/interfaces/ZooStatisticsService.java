package org.example.application.interfaces;

import org.example.domain.model.Enclosure;
import org.example.domain.valueobjects.Species;

import java.util.List;
import java.util.Map;

public interface ZooStatisticsService {
    public Map<Species, Long> getAnimalStatistics();

    public List<Enclosure> findAvailableEnclosures();
}
