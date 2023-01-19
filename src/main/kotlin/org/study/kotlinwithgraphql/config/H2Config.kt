/*
package org.study.kotlinwithgraphql.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import java.util.Properties
import javax.sql.DataSource

@Configuration
class H2Config(private val dataSourceHikari: DataSource) {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    fun hibernateProperties(): Properties {
        return Properties()
    }

    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSourceHikari
        em.setPackagesToScan("org.study.kotlinwithgraphql.domain")
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()
        em.setJpaProperties(hibernateProperties())
        return em
    }

}
*/
