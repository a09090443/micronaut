package com.zipe.controller

import com.zipe.entity.Book
import com.zipe.repository.BookRepository
import com.zipe.repository.UserRepository
import com.zipe.service.TestService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/book")
open class BookController(
    private val testService: TestService
) {

    fun list():List<Book> = testService.findBooks()
}