package org.example.infrastructure.persistence;

import org.example.domain.model.Enclosure;
import org.example.domain.repositories.EnclosureRepository;
import org.example.domain.valueobjects.EnclosureType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEnclosureRepository implements EnclosureRepository {
    private final List<Enclosure> enclosures = new ArrayList<>();
    private long nextId = 1;

    public InMemoryEnclosureRepository() {

    }

    @Override
    public Enclosure add(Enclosure enclosure) {
        Enclosure newEnclosure = new Enclosure(
                nextId++,
                enclosure.getType(),
                enclosure.getSize(),
                enclosure.getMaxCapacity()
        );
        enclosures.add(newEnclosure);
        return newEnclosure;
    }

    @Override
    public Enclosure update(Enclosure enclosure) {
        for (int i = 0; i < enclosures.size(); i++) {
            if (enclosures.get(i).getId() == enclosure.getId()) {
                enclosures.set(i, enclosure);
            }
        }
        return enclosure;
    }

    @Override
    public Optional<Enclosure> findById(long id) {
        return enclosures.stream().filter(it -> it.getId() == id).findFirst();
    }

    @Override
    public List<Enclosure> findAll() {
        return new ArrayList<>(enclosures);
    }

    @Override
    public void delete(long id) {
        enclosures.removeIf(it -> it.getId() == id);
    }

    @Override
    public List<Enclosure> findByType(EnclosureType type) {
        return enclosures.stream().filter(it -> it.getType() == type).toList();
    }
}
