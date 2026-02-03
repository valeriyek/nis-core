package ru.nis.bank.service;

import ru.nis.bank.model.Bank;
import ru.nis.bank.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    private final BankRepository repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public Bank save(Bank bank) {
        return repository.save(bank);
    }

    public List<Bank> getAll() {
        return repository.findAll();
    }

    public Bank getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
