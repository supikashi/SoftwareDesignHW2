package org.example.domain.valueobjects;

public record Species(
        String name,
        EnclosureType type
) {
    public Species {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be empty");
        }
    }
}