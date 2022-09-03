package com.zipe.repository

import com.zipe.entity.Book
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import javax.persistence.EntityManager

@Repository
interface BookRepository : CrudRepository<Book, Long> {
    fun findByName(name: String): Book?
}
