package org.study.kotlinwithgraphql.controller

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController
import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import org.study.kotlinwithgraphql.service.AccountService

@RestController
class AccountController(private val accountService: AccountService) {

    @QueryMapping
    fun getAccountsByUserId(@Argument userId: Long): List<AccountDto> {
        return accountService.getAccountsByUserId(userId)
    }
}