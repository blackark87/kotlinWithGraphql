package org.study.kotlinwithgraphql.domain.account.entity

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "BANK_ACCOUNT")
class AccountEntity {

    @Column("user_id")
    var userId: Long? = null
    @Column("account_no")
    var accountNo: String? = null
}