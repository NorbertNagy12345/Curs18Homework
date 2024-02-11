package org.fasttrackit.curs18.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs18.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("transaction")
@RequiredArgsConstructor
public class TransactionController {

        private final TransactionController service;

        @GetMapping
        public List<Transaction> getAllTransaction() {

            return service.getAllTransaction();
        }

        @GetMapping("{id}")
        public Transaction getOneCountry(@PathVariable String id) {
            return service.getTransactionById(id);
        }

        @DeleteMapping("{id}")
        public Transaction deleteById(@PathVariable String id) {
            return service.deleteById(id);
        }

        @PostMapping
        public Transaction addCountry(@RequestBody Transaction newTransaction){
            return service.addNewTransaction(newTransaction);
        }

        @PutMapping("{id}")
        public Transaction replaceCountry(@PathVariable String id, @RequestBody Transaction replaceTransaction){
            return service.replaceCountry(id, replaceTransaction);
        }

    }

}
