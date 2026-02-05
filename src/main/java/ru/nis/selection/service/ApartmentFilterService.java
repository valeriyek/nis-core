package ru.nis.selection.service;

import ru.nis.apartment.model.Apartment;
import ru.nis.apartment.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentFilterService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentFilterService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> filter(
            Long developerId,
            Double minArea,
            Double maxArea,
            Double maxPrice
    ) {
        return apartmentRepository.findAll().stream()
                .filter(a -> developerId == null
                        || a.getDeveloper().getId().equals(developerId))
                .filter(a -> minArea == null || a.getArea() >= minArea)
                .filter(a -> maxArea == null || a.getArea() <= maxArea)
                .filter(a -> maxPrice == null || a.getPrice() <= maxPrice)
                .toList();
    }
}
