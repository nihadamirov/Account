package com.company.service;

import com.company.dto.AccountDto;
import com.company.dto.CreateAccountRequest;
import com.company.repository.AccountRepository;
import com.company.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){

    }
}
