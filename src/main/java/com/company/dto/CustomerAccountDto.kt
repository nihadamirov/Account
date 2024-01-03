package com.company.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val d: String,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transactions: Set<TransactionDto>?
)