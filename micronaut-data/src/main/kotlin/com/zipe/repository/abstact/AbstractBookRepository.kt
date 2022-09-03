package com.zipe.repository.abstact

import com.zipe.entity.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.transaction.annotation.TransactionalAdvice
import javax.persistence.EntityManager

@Repository
@TransactionalAdvice
abstract class AbstractBookRepository(
    private val entityManager: EntityManager
) : CrudRepository<Book, Long> {

    fun insert(book: Book) {
        entityManager.persist(book)
    }

    fun findBySn(sn: String): Any {
        return entityManager.createNativeQuery(
            "select * FROM Book WHERE sn = :sn",
            Book::class.java
        ).setParameter("sn", sn).singleResult
    }
}