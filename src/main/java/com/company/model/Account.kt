package com.company.model

import jakarta.persistence.*
import  jakarta.persistence.CascadeType
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Account(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = "",

        val balance: BigDecimal? = BigDecimal.ZERO,



        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "customer_id", nullable = false)
        val customer: Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val transaction: Set<Transaction>?

){

        val creationDate: Any = TODO()

        constructor(customer: Customer?, balance: BigDecimal?) : this(
                "",
                customer = customer,
                balance = balance,
                transaction = null
        ) {
        }

}



