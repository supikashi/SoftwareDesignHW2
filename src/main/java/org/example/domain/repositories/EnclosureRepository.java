package org.example.domain.repositories;

import org.example.domain.model.Enclosure;
import org.example.domain.valueobjects.EnclosureType;

import java.util.List;
import java.util.Optional;

public interface EnclosureRepository {
    Enclosure add(Enclosure enclosure);
    Enclosure update(Enclosure enclosure);
    Optional<Enclosure> findById(long id);
    List<Enclosure> findAll();
    void delete(long id);

    List<Enclosure> findByType(EnclosureType type);
}
