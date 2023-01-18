package org.study.kotlinwithgraphql.domain.user.dto

import java.time.LocalDate

data class UserDto(
    val id: Long?,
    val name: String?,
    val age : Int?,
    val registeredAt : LocalDate?
)
