package org.study.kotlinwithgraphql.service

import org.springframework.stereotype.Service
import mu.KotlinLogging
import org.study.kotlinwithgraphql.domain.user.dto.UserDto
import org.study.kotlinwithgraphql.domain.user.entity.UserEntity
import org.study.kotlinwithgraphql.mapper.UserMapper
import org.study.kotlinwithgraphql.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    private val log = KotlinLogging.logger {}

    fun getUserById(id: Long): UserDto? {
        val userEntity: UserEntity? = userRepository.getByUserId(id)

        val userDto: UserDto = userEntity?.let{
            return UserMapper.INSTANCE.toDto(it)
        } ?:run {
            log.info { "UserEntity is null" }
            return null
        }

        return userDto
    }

    fun addUser(userDto: UserDto): UserDto? {
        val userEntity: UserEntity = UserMapper.INSTANCE.toEntity(userDto)
        val savedUserEntity: UserEntity = userRepository.save(userEntity)
        val savedUserDto: UserDto = UserMapper.INSTANCE.toDto(savedUserEntity)

        log.info("userEntity: {}", userEntity.toString())
        log.info("savedUserEntity: {}", savedUserEntity.toString())
        log.info("savedUserDto: {}", savedUserDto.toString())

        return savedUserDto
    }
}