package org.study.kotlinwithgraphql.controller
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController
import org.study.kotlinwithgraphql.domain.user.dto.UserDto
import org.study.kotlinwithgraphql.service.UserService
import reactor.core.publisher.Mono

@RestController
class UserController(private val userService: UserService) {

    @QueryMapping
    fun getUserById(@Argument id: Long): Mono<UserDto>? {
        return userService.getUserById(id)
    }

    @MutationMapping
    fun addUser(@Argument user: UserDto): UserDto? {
        return userService.addUser(user)
    }
}