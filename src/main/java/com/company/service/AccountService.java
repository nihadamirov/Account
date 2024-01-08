package com.company.service;

import com.company.dto.AccountDto;
import com.company.dto.CreateAccountRequest;
import com.company.model.Account;
import com.company.model.Customer;
import com.company.repository.AccountRepository;
import com.company.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer  customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest
                        .getInitialCredit(),
                LocalDateTime.now()
               );

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){

        }
    }
}
