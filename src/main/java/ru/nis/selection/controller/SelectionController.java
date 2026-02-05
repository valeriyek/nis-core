package ru.nis.selection.controller;

import ru.nis.apartment.model.Apartment;
import ru.nis.selection.dto.SelectionRequest;
import ru.nis.selection.service.SelectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/selection")
public class SelectionController {

    private final SelectionService selectionService;

    public SelectionController(SelectionService selectionService) {
        this.selectionService = selectionService;
    }

    @PostMapping
    public List<Apartment> select(@RequestBody SelectionRequest request) {
        return selectionService.selectApartments(request);
    }
}
