package org.example.domain.model;

import org.example.domain.valueobjects.HealthStatus;
import org.example.domain.valueobjects.Species;
import org.example.domain.valueobjects.Gender;

import java.time.LocalDate;
import java.util.Objects;

public class Animal {
    private final long id;
    private final Species species;
    private final String namee;
    private final LocalDate birthDate;
    private final Gender gender;
    private final String favoriteFood;
    private HealthStatus healthStatus;
    private long enclosureId;

    public Animal(
            long id,
            Species species,
            String name,
            LocalDate birthDate,
            Gender gender,
            String favoriteFood,
            HealthStatus healthStatus,
            long enclosureId
    ) {
        this.id = id;
        this.species = Objects.requireNonNull(species, "Species cannot be null");
        this.namee = Objects.requireNonNull(name, "Name cannot be null");
        this.birthDate = Objects.requireNonNull(birthDate, "Birth date cannot be null");
        this.gender = Objects.requireNonNull(gender, "Gender cannot be null");
        this.favoriteFood = Objects.requireNonNull(favoriteFood, "Favorite food cannot be null");
        this.healthStatus = Objects.requireNonNull(healthStatus, "Health status cannot be null");
        this.enclosureId = enclosureId;
    }

    public long getId() { return id; }

    public Species getSpecies() { return species; }

    public String getName() { return namee; }

    public LocalDate getBirthDate() { return birthDate; }

    public Gender getGender() { return gender; }

    public String getFavoriteFood() { return favoriteFood; }

    public HealthStatus getHealthStatus() { return healthStatus; }

    public long getEnclosureId() { return enclosureId; }

    public void feed() { System.out.println(species + " " + namee + " is fed"); }

    public void makeSick() { healthStatus = HealthStatus.SICK; }

    public void cure() { healthStatus = HealthStatus.HEALTHY; }

    public void move(long newEnclosureId) { enclosureId = newEnclosureId; }
}
