package org.example.presentation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.application.interfaces.EnclosureService;
import org.example.domain.model.Enclosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enclosures")
@Tag(name = "Enclosure Management")
public class EnclosureController {
    private final EnclosureService enclosureService;
    @Autowired
    public EnclosureController(EnclosureService enclosureService) {
        this.enclosureService = enclosureService;
    }

    @PostMapping
    @Operation(summary = "Create new enclosure")
    public Enclosure createEnclosure(@RequestBody Enclosure request) {
        return enclosureService.addEnclosure(request);
    }

    @PutMapping
    @Operation(summary = "Update enclosure")
    public Enclosure updateEnclosure(@RequestBody Enclosure request) {
        return enclosureService.updateEnclosure(request);
    }

    @GetMapping
    @Operation(summary = "Get enclosures list")
    public List<Enclosure> getAllEnclosures() {
        return enclosureService.getAllEnclosures();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get enclosure by ID")
    public Optional<Enclosure> getEnclosure(@PathVariable long id) {
        return enclosureService.getEnclosureById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete enclosure")
    public void deleteEnclosure(@PathVariable long id) {
        enclosureService.deleteEnclosure(id);
    }
}