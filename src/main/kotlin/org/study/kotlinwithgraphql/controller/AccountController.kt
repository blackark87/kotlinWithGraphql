package org.study.kotlinwithgraphql.controller

import kotlinx.coroutines.flow.Flow
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController
import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import org.study.kotlinwithgraphql.service.AccountService
import reactor.core.publisher.Flux

@RestController
class AccountController(private val accountService: AccountService) {

    @QueryMapping
    suspend fun getAccountsByUserId(@Argument userId: Long): Flow<AccountDto>? {
        return accountService.getAccountsByUserId(userId)
    }
}