package org.study.kotlinwithgraphql.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity

interface AccountRepository: JpaRepository<AccountEntity, Long> {

    fun findAllByUserId(userId: Long): List<AccountEntity>
}