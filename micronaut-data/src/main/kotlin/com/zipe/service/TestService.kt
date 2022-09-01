package com.zipe.service

import com.zipe.entity.Book
import com.zipe.entity.HomeProduction
import com.zipe.entity.User
import com.zipe.repository.BookRepository
import com.zipe.repository.HomeProductionRepository
import com.zipe.repository.UserRepository
import com.zipe.repository.impl.InfoRepositoryImpl
import io.micronaut.transaction.annotation.TransactionalAdvice
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class TestService(
    private val userRepository: UserRepository,
    private val bookRepository: BookRepository,
    private val infoRepositoryImpl: InfoRepositoryImpl,
    private val homeProductionRepository: HomeProductionRepository
) {
    @TransactionalAdvice
    open fun test(content: String) {
        homeProductionRepository.save(HomeProduction(name = "home", address = "ss"))

        val homes = homeProductionRepository.findByName("home")

        println(homes)

        try {


            val tests = homeProductionRepository.findAll()
            println(tests)
//            homeProductionRepository.save(HomeProduction(name = "home2", address = "33333"))

            throw Exception("test")
        } catch (e: Exception) {
            throw e;
        }
//        infoRepositoryImpl.save("測試")
//        println("test")
//        val user = User(name="zipe")
//        userRepositoryImpl.save(user)
//        val result = userRepositoryImpl.findAll()
//        println(result)
    }

    open fun test2(){

        val tests = homeProductionRepository.findAll()
        println(tests)
    }

    fun findBooks(): List<Book> = bookRepository.findAll().toList()
}
