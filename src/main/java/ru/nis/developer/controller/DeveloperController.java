package ru.nis.developer.controller;

import ru.nis.developer.model.Developer;
import ru.nis.developer.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        return service.save(developer);
    }

    @GetMapping
    public List<Developer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
