package org.study.kotlinwithgraphql.repository

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import org.study.kotlinwithgraphql.domain.user.entity.UserEntity
import reactor.core.publisher.Mono

@Repository
interface UserRepository: CoroutineCrudRepository<UserEntity, Long> {
    fun getByUserId(id: Long): Mono<UserEntity>?
    fun save(userEntity: UserEntity): UserEntity?
}