package com.zipe.controller

import com.zipe.service.BookService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/book")
open class BookController(
    private val bookService: BookService
) {
    @Get("/list/{name}")
    fun getBooks(name: String) {
        val books = bookService.findBooksByJpa()
        val bookJdbc = bookService.findBookByJdbc(name)
        val bookNamedJdbc = bookService.findBookByNamedJdbc(name)

        println(books)
        println(bookJdbc)
        println(bookNamedJdbc)
    }
}