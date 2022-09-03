package com.zipe.service

import com.zipe.entity.Book
import com.zipe.repository.BookRepository
import com.zipe.repository.abstact.AbstractBookRepository
import com.zipe.repository.impl.BookRepositoryImpl
import jakarta.inject.Singleton
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Singleton
class BookService(
    private val bookRepository: BookRepository,
    private val namedJdbcTemplate: NamedParameterJdbcTemplate,
    private val abstractBookRepository: AbstractBookRepository,
    private val bookRepositoryImpl: BookRepositoryImpl,
    private val jdbcTemplate: JdbcTemplate
) {

    fun findBooksByJpa(): List<Book> {
        return bookRepository.findAll().toList()
    }

    fun findBookByName(name: String) = bookRepository.findByName(name)

    fun findBookBySn(sn: String) = abstractBookRepository.findBySn(sn)

    fun findBookByJdbc(name: String): Book? {
        return jdbcTemplate.queryForObject(
            """Select * from Book where name=?""",
            BeanPropertyRowMapper(Book::class.java),
            name
        )
    }

    fun findBookByNamedJdbc(name: String): Book? {
        return namedJdbcTemplate.queryForObject(
            """Select * from Book where name=:name""",
            mapOf("name" to name),
            BeanPropertyRowMapper(Book::class.java)
        )
    }

    fun insertBook(book: Book) {
        bookRepository.save(book)
    }

    fun insertBookByEntityManager(book: Book) = abstractBookRepository.insert(book)

    fun insertBookByTransactionManager(book: Book) = bookRepositoryImpl.insert(book)
}