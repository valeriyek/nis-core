package ru.nis.service;

import ru.nis.domain.Developer;
import ru.nis.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    public Developer save(Developer developer) {
        return repository.save(developer);
    }

    public List<Developer> getAll() {
        return repository.findAll();
    }

    public Developer getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
