package org.study.kotlinwithgraphql.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.study.kotlinwithgraphql.domain.user.entity.UserEntity

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {

    fun getByUserId(id: Long): UserEntity?
}