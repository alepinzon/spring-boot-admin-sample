package com.example.controller;

import com.example.controller.converter.TransactionConverter;
import com.example.controller.resource.TransactionResource;
import com.example.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionConverter transactionConverter;

    public TransactionController(final TransactionService transactionService,
                                 final TransactionConverter transactionConverter) {
        this.transactionService = transactionService;
        this.transactionConverter = transactionConverter;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<TransactionResource> getTransactions() {
        return transactionService.getTransactions()
                .stream()
                .map(transaction -> transactionConverter.convert(transaction))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public TransactionResource getTransaction(@PathVariable final Integer id) {
        return transactionConverter.convert(transactionService.getTransaction(id));
    }
}
