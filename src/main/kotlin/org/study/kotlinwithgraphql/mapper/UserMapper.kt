package org.study.kotlinwithgraphql.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.NullValueMappingStrategy
import org.mapstruct.factory.Mappers
import org.study.kotlinwithgraphql.domain.user.dto.UserDto
import org.study.kotlinwithgraphql.domain.user.entity.UserEntity

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
interface UserMapper: BaseMapper<UserDto, UserEntity> {
    companion object {
        val INSTANCE: UserMapper = Mappers.getMapper(UserMapper::class.java)
    }

    @Mapping(source = "userId", target = "id")
    override fun toDto(entity: UserEntity): UserDto

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "registeredAt", target = "registeredAt", defaultExpression = "java(java.time.LocalDate.now())")
    override fun toEntity(dto: UserDto): UserEntity
}