package org.study.kotlinwithgraphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
//@EnableAspectJAutoProxy
class KotlinWithGraphqlApplication

fun main(args: Array<String>) {
    runApplication<KotlinWithGraphqlApplication>(*args)
}
