package org.study.kotlinwithgraphql.repository

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity

@Repository
interface AccountRepository: CoroutineCrudRepository<AccountEntity, Long> {
    fun findAllByUserId(userId: Long): Flow<AccountEntity>?
}