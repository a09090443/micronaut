package com.zipe.repository.impl

import com.zipe.entity.Info
import com.zipe.repository.InfoRepository
import io.micronaut.transaction.SynchronousTransactionManager
import jakarta.inject.Singleton
import java.sql.Connection
import javax.persistence.EntityManager

@Singleton
class InfoRepositoryImpl(
    private val entityManager: EntityManager,
    private val transactionManager: SynchronousTransactionManager<Connection>
) : InfoRepository {
    override fun save(address: String) {
        return transactionManager.executeWrite {
            val info = Info(address = address)
            entityManager.persist(info)
        }
    }
}
