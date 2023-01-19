package org.study.kotlinwithgraphql.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service
import mu.KotlinLogging
import org.study.kotlinwithgraphql.domain.account.dto.AccountDto
import org.study.kotlinwithgraphql.domain.account.entity.AccountEntity
import org.study.kotlinwithgraphql.domain.user.dto.UserDto
import org.study.kotlinwithgraphql.domain.user.entity.UserEntity
import org.study.kotlinwithgraphql.mapper.AccountMapper
import org.study.kotlinwithgraphql.mapper.UserMapper
import org.study.kotlinwithgraphql.repository.AccountRepository
import org.study.kotlinwithgraphql.repository.UserRepository
import reactor.core.publisher.Mono

@Service
class UserService(private val userRepository: UserRepository, private val accountRepository: AccountRepository) {

    private val log = KotlinLogging.logger {}

    fun getUserById(id: Long): Mono<UserDto>? {
        val userEntity: Mono<UserEntity>? = userRepository.getByUserId(id)

        userEntity?.let{user ->
            val accountEntity: Flow<AccountEntity>? = accountRepository.findAllByUserId(id)

            accountEntity?.let{account ->
                account.map {
                    log.info{"2 $it"}
                }
            }

            return user.map {
                UserMapper.INSTANCE.toDto(it)
            }
        } ?:run {
            log.info { "UserEntity is null" }
            return null
        }
    }

    fun addUser(userDto: UserDto): UserDto? {
        val userEntity: UserEntity = UserMapper.INSTANCE.toEntity(userDto)
        val savedUserEntity: UserEntity? = userRepository.save(userEntity)

        val savedUserDto: UserDto = savedUserEntity?.let{
            return UserMapper.INSTANCE.toDto(it)
        } ?:run {
            log.info { "UserEntity is null" }
            return null
        }

        return savedUserDto
    }
}