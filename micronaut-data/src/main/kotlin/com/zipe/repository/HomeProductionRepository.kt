package com.zipe.repository

import com.zipe.entity.HomeProduction
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.transaction.annotation.ReadOnly
import io.micronaut.transaction.annotation.TransactionalAdvice
import javax.persistence.EntityManager

@Repository
abstract class HomeProductionRepository(private val entityManager: EntityManager) :
    CrudRepository<HomeProduction, Long> {

    @TransactionalAdvice
    fun insert(homeProduction: HomeProduction) {
        entityManager.persist(homeProduction)
    }

    @ReadOnly
    fun findByName(name: String): List<Any?>? {
        return entityManager.createNativeQuery(
            "select * FROM home_production AS home WHERE home.name = :name",
            HomeProduction::class.java
        ).setParameter("name", name).resultList
    }

}
