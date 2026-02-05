package ru.nis.apartment.controller;

import ru.nis.apartment.model.Apartment;
import ru.nis.apartment.service.ApartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    private final ApartmentService service;

    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @PostMapping
    public Apartment create(@RequestBody Apartment apartment) {
        return service.save(apartment);
    }

    @GetMapping
    public List<Apartment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Apartment getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
