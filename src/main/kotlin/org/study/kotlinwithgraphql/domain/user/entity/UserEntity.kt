package org.study.kotlinwithgraphql.domain.user.entity

import jakarta.persistence.*
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity
import java.time.LocalDate

@Entity
@Table(name = "BANK_USER")
class UserEntity {

    @Id
    @Column(name = "ID", nullable = false)
    var userId: Long? = null

    @Column(name = "NAME", length = 50)
    var name: String? = null

    @Column(name = "REG_DATE")
    var registeredAt: LocalDate? = LocalDate.now()

    @Column(name = "AGE")
    var age: Int? = null

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    var accounts: List<AccountEntity>? = null

}