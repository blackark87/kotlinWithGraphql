package org.study.kotlinwithgraphql.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service
import mu.KotlinLogging
import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity
import org.study.kotlinwithgraphql.mapper.AccountMapper
import org.study.kotlinwithgraphql.mapper.UserMapper
import org.study.kotlinwithgraphql.repository.AccountRepository
import reactor.core.publisher.Flux

@Service
class AccountService(private val accountRepository: AccountRepository) {

    private val log = KotlinLogging.logger {}

    suspend fun getAccountsByUserId(userId: Long): Flow<AccountDto>? {
        log.info { "getAccountsByUserId: $userId" }

        val accounts: Flow<AccountEntity>? = accountRepository.findAllByUserId(userId)

        accounts ?.let {
            return it.map { accounts -> AccountMapper.INSTANCE.toDto(accounts) }
        } ?:run {
            log.info {"userId $userId account is null"}
            return null
        }
    }
}