package org.study.kotlinwithgraphql.service

import org.springframework.stereotype.Service
import mu.KotlinLogging
import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity
import org.study.kotlinwithgraphql.mapper.AccountMapper
import org.study.kotlinwithgraphql.repository.AccountRepository

@Service
class AccountService(private val accountRepository: AccountRepository) {

    private val log = KotlinLogging.logger {}

    fun getAccountsByUserId(userId: Long): List<AccountDto> {
        log.info { "getAccountsByUserId: $userId" }

        val accounts: List<AccountEntity> = accountRepository.findAllByUserId(userId)

        return AccountMapper.instance.toDtoList(accounts)
    }
}