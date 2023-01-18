package org.study.kotlinwithgraphql.domain.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
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

}