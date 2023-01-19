package org.study.kotlinwithgraphql.mapper

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity

@Mapper
interface AccountMapper: BaseMapper<AccountDto, AccountEntity> {
    companion object {
        val INSTANCE: AccountMapper = Mappers.getMapper(AccountMapper::class.java)
    }
}