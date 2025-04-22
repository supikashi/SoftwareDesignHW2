package org.example.application.services;

import org.example.application.interfaces.EnclosureService;
import org.example.domain.model.Enclosure;
import org.example.domain.repositories.EnclosureRepository;
import org.example.domain.valueobjects.EnclosureType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnclosureServiceImpl implements EnclosureService {
    private final EnclosureRepository enclosureRepository;

    public EnclosureServiceImpl(EnclosureRepository enclosureRepository) {
        this.enclosureRepository = enclosureRepository;
    }

    @Override
    public Optional<Enclosure> getEnclosureById(long id) {
        return enclosureRepository.findById(id);
    }

    @Override
    public List<Enclosure> getAllEnclosures() {
        return enclosureRepository.findAll();
    }

    @Override
    public List<Enclosure> getAllEnclosuresByType(EnclosureType type) {
        return enclosureRepository.findByType(type);
    }

    @Override
    public Enclosure addEnclosure(Enclosure enclosure) {
        return enclosureRepository.add(enclosure);
    }

    @Override
    public Enclosure updateEnclosure(Enclosure enclosure) {
        return enclosureRepository.update(enclosure);
    }

    @Override
    public void deleteEnclosure(long id) {
        enclosureRepository.delete(id);
    }
}
