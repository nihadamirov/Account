package com.company.service;

import com.company.model.Account;
import com.company.model.Transaction;
import com.company.repository.TransactionRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Service
public class TransactionService {
    private Logger logger = (Logger) LoggerFactory.getLogger(TransactionService.class);
    private  final TransactionRepository  transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount){
        return transactionRepository.save(new Transaction(amount,account));
    }
}
