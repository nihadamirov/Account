package com.company.service;

import com.company.dto.AccountDto;
import com.company.dto.AccountDtoConverter;
import com.company.dto.CreateAccountRequest;
import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Transaction;
import com.company.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit()
                );

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(),account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }
}
