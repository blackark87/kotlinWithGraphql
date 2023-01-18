package org.study.kotlinwithgraphql.domain.user.dto

import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import java.time.LocalDate

data class UserDto(
    val id: Long?,
    val name: String?,
    val age : Int?,
    val registeredAt : LocalDate?,
    val account: List<AccountDto>?
)
