package com.zipe.service

import com.zipe.entity.Book
import jakarta.inject.Singleton
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Singleton
class JdbcTestService(
    private val namedJdbcTemplate: NamedParameterJdbcTemplate
) {

    fun findBookByName(name: String): Book? {
        return namedJdbcTemplate.queryForObject(
            """Select * from Book where name=:name""",
            mapOf("name" to name),
            BeanPropertyRowMapper(Book::class.java)
        )
    }
}