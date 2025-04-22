package org.example.domain.valueobjects;

public record Size(double length, double width, double height) {
    public Size {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Size dimensions must be positive");
        }
    }
}
