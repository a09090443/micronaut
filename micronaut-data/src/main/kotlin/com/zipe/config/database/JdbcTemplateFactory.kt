package com.zipe.config.database

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Factory
class JdbcTemplateFactory(
    var dataSource: DataSource
) {

    @Bean
    @Singleton
    fun jdbcTemplate(): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @Singleton
    fun namedJdbcTemplate(): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }
}