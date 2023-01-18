package org.study.kotlinwithgraphql.domain.transaction.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "BANK_TRANSACTION")
class TransactionEntity {

    @Id
    @GeneratedValue(generator = "BANK_TRANSACTION_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "BANK_TRANSACTION_SEQ", sequenceName = "BANK_TRANSACTION_SEQ", allocationSize = 1)
    val rowId: Long? = null

    @Column(name = "ACCOUNT_NO", length = 50)
    val accountNo: String? = null

    @Column(name = "DEPOSIT_YN", length = 1)
    val depositYn: String? = null

    @Column(name = "AMOUNT")
    val amount: Double? = null

    @Column(name = "TRANSACTION_DATE")
    val transactionAt: LocalDate? = null
}