package com.example.service;

import com.example.entity.Transaction;
import com.example.respository.TransactionRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Cacheable(value = "transaction",key = "#id")
    public Transaction getTransaction(final Integer id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found."));
    }

    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

}
