package ru.nis.bank.controller;

import ru.nis.bank.model.Bank;
import ru.nis.bank.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping
    public Bank create(@RequestBody Bank bank) {
        return service.save(bank);
    }

    @GetMapping
    public List<Bank> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Bank getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
