package org.example.application.interfaces;

import org.example.domain.model.Enclosure;
import org.example.domain.valueobjects.EnclosureType;

import java.util.List;
import java.util.Optional;

public interface EnclosureService {
    public Optional<Enclosure> getEnclosureById(long id);

    public List<Enclosure> getAllEnclosures();

    public List<Enclosure> getAllEnclosuresByType(EnclosureType type);

    public Enclosure addEnclosure(Enclosure enclosure);

    public Enclosure updateEnclosure(Enclosure enclosure);

    public void deleteEnclosure(long id);
}
