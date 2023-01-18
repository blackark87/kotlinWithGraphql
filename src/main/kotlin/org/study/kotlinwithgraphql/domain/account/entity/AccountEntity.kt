package org.study.kotlinwithgraphql.domain.account.entity

import jakarta.persistence.*

@Entity
@Table(name = "BANK_ACCOUNT")
class AccountEntity {

    @Id
    @Column(name = "row_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BANK_ACCOUNT_SEQ")
    @SequenceGenerator(name = "BANK_ACCOUNT_SEQ", sequenceName = "BANK_ACCOUNT_SEQ", allocationSize = 1)
    val rowId: Long? = null

    @Column(name = "ID")
    val userId: Long? = null

    @Column(name = "ACCOUNT_NO", length = 50)
    val accountNo: String? = null
}