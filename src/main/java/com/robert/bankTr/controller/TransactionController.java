package com.robert.bankTr.controller;

import com.robert.bankTr.miscellaneous.NotEnoughFondsException;
import com.robert.bankTr.miscellaneous.UserNotFoundException;
import com.robert.bankTr.model.Transaction;
import com.robert.bankTr.model.User;

import com.robert.bankTr.repository.TransactionRepository;
import com.robert.bankTr.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost")
@RestController
public class TransactionController {

    private final TransactionRepository repository;
    private UserRepository userRepository;

    @GetMapping("/transaction")
    List<Transaction> all() {
        return repository.findAll();
    }

    public TransactionController(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.repository = transactionRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {








        User from = userRepository.findById(newTransaction.getFromUser())
                .orElseThrow(() -> new UserNotFoundException(newTransaction.getFromUser()));
        User to = userRepository.findById(newTransaction.getToUser())
                .orElseThrow(() -> new UserNotFoundException(newTransaction.getToUser()));
        if (from.getAmount() >= newTransaction.getAmount()) {
            from.setAmount(from.getAmount() - newTransaction.getAmount());
            to.setAmount(to.getAmount() + newTransaction.getAmount());
            userRepository.save(from);
            userRepository.save(to);
            return repository.save(newTransaction);
        } else {
            throw new NotEnoughFondsException(newTransaction.getAmount());
        }
    }
}
