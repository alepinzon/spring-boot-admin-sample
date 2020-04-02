package com.example.controller.converter;

import com.example.controller.resource.TransactionResource;
import com.example.entity.Transaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter implements Converter<Transaction, TransactionResource> {
    @Override
    public TransactionResource convert(Transaction source) {
        return TransactionResource.builder()
                .id(source.getId())
                .description(source.getDescription())
                .createdAt(source.getCreatedAt())
                .build();
    }
}
