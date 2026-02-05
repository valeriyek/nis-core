package ru.nis.apartment.service;

import ru.nis.apartment.model.Apartment;
import ru.nis.apartment.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public Apartment save(Apartment apartment) {
        return repository.save(apartment);
    }

    public List<Apartment> getAll() {
        return repository.findAll();
    }

    public Apartment getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
