package ru.nis.selection.service;

import ru.nis.apartment.model.Apartment;
import ru.nis.selection.dto.SelectionRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectionService {

    private final ApartmentFilterService apartmentFilterService;
    private final BankFilterService bankFilterService;

    public SelectionService(ApartmentFilterService apartmentFilterService,
                            BankFilterService bankFilterService) {
        this.apartmentFilterService = apartmentFilterService;
        this.bankFilterService = bankFilterService;
    }

    public List<Apartment> selectApartments(SelectionRequest request) {

        double allowedPrice = request.getMaxPrice();

        if (request.getBankId() != null) {
            double bankLimit = bankFilterService.getMaxLoanAmount(request.getBankId());
            allowedPrice = Math.min(allowedPrice, bankLimit);
        }

        return apartmentFilterService.filter(
                request.getDeveloperId(),
                request.getMinArea(),
                request.getMaxArea(),
                allowedPrice
        );
    }
}
