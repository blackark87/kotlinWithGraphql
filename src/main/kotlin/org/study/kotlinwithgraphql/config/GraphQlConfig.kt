package org.study.kotlinwithgraphql.config

import graphql.scalars.ExtendedScalars
import graphql.schema.idl.RuntimeWiring
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer

@Configuration
class GraphQlConfig: RuntimeWiringConfigurer {

    override fun configure(builder: RuntimeWiring.Builder) {
        builder
            .scalar(ExtendedScalars.DateTime)
            .scalar(ExtendedScalars.Date)
            .scalar(ExtendedScalars.Time)
            .scalar(ExtendedScalars.Json)
            .scalar(ExtendedScalars.Url)
            .scalar(ExtendedScalars.GraphQLLong)
            .scalar(ExtendedScalars.GraphQLBigDecimal)
            .scalar(ExtendedScalars.Currency)
            .build()
    }

}