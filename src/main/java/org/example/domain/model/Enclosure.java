package org.example.domain.model;

import org.example.domain.exceptions.EnclosureException;
import org.example.domain.valueobjects.EnclosureType;
import org.example.domain.valueobjects.Size;

import java.util.Objects;

public class Enclosure {
    private final long id;
    private final EnclosureType type;
    private final Size size;
    private int currentAnimals;
    private final int maxCapacity;

    public Enclosure(
            long id,
            EnclosureType type,
            Size size,
            int maxCapacity
    ) {
        this.id = id;
        this.type = Objects.requireNonNull(type, "Type cannot be null");
        this.size = Objects.requireNonNull(size, "Size cannot be null");
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be positive");
        }
        this.maxCapacity = maxCapacity;
        this.currentAnimals = 0;
    }

    public void addAnimal() {
        if (currentAnimals >= maxCapacity) {
            throw new EnclosureException("Cannot add animal - enclosure is full");
        }
        currentAnimals++;
    }

    public void removeAnimal() {
        if (currentAnimals <= 0) {
            throw new EnclosureException("No animals to remove");
        }
        currentAnimals--;
    }

    public void clean() { System.out.println("The enclosure is cleaned"); }

    public long getId() { return id; }

    public EnclosureType getType() { return type; }

    public Size getSize() { return size; }

    public int getCurrentAnimals() { return currentAnimals; }

    public int getMaxCapacity() { return maxCapacity; }

}
