package org.study.kotlinwithgraphql.domain.transaction.entity


import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table(name = "BANK_TRANSACTION")
class TransactionEntity {

    @Column("account_no")
    var accountNo: String? = null
    @Column("deposit_yn")
    var depositYn: String? = null
    @Column("amount")
    var amount: Double? = null
    @Column("transaction_date")
    var transactionAt: LocalDate? = null
}