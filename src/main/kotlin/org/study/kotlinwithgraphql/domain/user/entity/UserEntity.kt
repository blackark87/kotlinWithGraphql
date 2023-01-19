package org.study.kotlinwithgraphql.domain.user.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table(name = "BANK_USER")
class UserEntity {

    @Id
    @Column("id")
    var userId: Long? = null
    @Column("name")
    var name: String? = null
    @Column("reg_date")
    var registeredAt: LocalDate? = LocalDate.now()
    @Column("age")
    var age: Int? = null
}