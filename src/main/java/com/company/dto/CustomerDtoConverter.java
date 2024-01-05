package com.company.dto;

import com.company.model.Customer;

public class CustomerDtoConverter {
    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if(from == null){
            return new AccountCustomerDto("", "", "");
        }else{

        }
        return new AccountCustomerDto(from.getId(),from.getName(),from.getSurname());
    }
}
