package org.study.kotlinwithgraphql.mapper

interface BaseMapper<Dto, Entity>  {
    fun toDto(entity: Entity): Dto
    fun toEntity(dto: Dto): Entity
    fun toDtoList(entities: List<Entity>): List<Dto>
    fun toEntityList(dtos: List<Dto>): List<Entity>
}