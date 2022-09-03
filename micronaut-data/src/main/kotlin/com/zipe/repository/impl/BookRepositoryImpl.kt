package com.zipe.repository.impl

import com.zipe.entity.Book
import io.micronaut.transaction.SynchronousTransactionManager
import jakarta.inject.Singleton
import java.sql.Connection
import javax.persistence.EntityManager

@Singleton
class BookRepositoryImpl(
    private val entityManager: EntityManager,
    private val transactionManager: SynchronousTransactionManager<Connection>
) {

    fun insert(book: Book) {
        return transactionManager.executeWrite {
            entityManager.persist(book)
        }
    }

}