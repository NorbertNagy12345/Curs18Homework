package org.fasttrackit.curs18.service;

import lombok.Data;
import lombok.Getter;
import org.fasttrackit.curs18.exceptions.ResourceNotFoundException;
import org.fasttrackit.curs18.model.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
@Getter
public class TransactionService {
    private final List<Transaction> transaction = new ArrayList<>();

    public List<Transaction> getAllTransaction() {
        return transaction;
    }

    public Transaction getTransactionById(String id) {
        return transaction.stream()
                .filter(transactions -> transactions.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id:%s was not found".formatted(id)));
    }
    public Transaction getAllTransactionByProduct(String product){
        return transaction.stream()
                .filter(transactions -> transactions.product().equals(product))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with product:%s was not found".formatted(product)));
    }
    public List<Transaction> getTransactionByMinAmount(double amount){
        return transaction.stream()
                .filter(transactions -> transactions.amount() >= amount)
                .toList();
    }
    public List<Transaction> getTransactionByMaxAmount(double amount){
        return transaction.stream()
                .filter(transactions -> transactions.amount() <= amount)
                .toList();

    }
    }
}
