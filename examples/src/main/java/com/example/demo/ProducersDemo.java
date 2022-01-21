package com.example.demo;

import com.example.demo.dto.Transaction;
import com.example.demo.dto.TransactionSummary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class ProducersDemo {

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable String id) {
        return new Transaction();
    }

    @GetMapping(value = "/{id}", produces = "application/vnd.restdemo.summary+json")
    public TransactionSummary getTransactionSummary(@PathVariable String id) {
        return new TransactionSummary();
    }
}
