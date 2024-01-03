package com.company.dto

import com.company.model.Account

data class CustomerDto(

    val id: String?,

    val name: String,
    val surname: String,
    val accounts: Set<Account>?
)


