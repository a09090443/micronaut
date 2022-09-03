package com.zipe.controller

import com.zipe.entity.Book
import com.zipe.service.BookService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller("/book")
open class BookController(
    private val bookService: BookService
) {
    @Get("/list/name/{name}")
    fun getBooks(name: String) {
        val books = bookService.findBooksByJpa()
        val book = bookService.findBookByName(name)
        val bookJdbc = bookService.findBookByJdbc(name)
        val bookNamedJdbc = bookService.findBookByNamedJdbc(name)

        println(books)
        println(book)
        println(bookJdbc)
        println(bookNamedJdbc)
    }

    @Get("/list/sn/{sn}")
    fun getBook(sn: String) {
        val book = bookService.findBookBySn(sn)
    }

    @Post("/add", consumes = [MediaType.APPLICATION_JSON])
    fun addBook(@Body book: Book) {
        bookService.insertBook(book)
    }

    @Post("/addEntityManager", consumes = [MediaType.APPLICATION_JSON])
    fun addBookByEntityManager(@Body book: Book) {
        bookService.insertBookByEntityManager(book)
    }

    @Post("/addTransactionManager", consumes = [MediaType.APPLICATION_JSON])
    fun addBookByTransactionManager(@Body book: Book) {
        bookService.insertBookByTransactionManager(book)
    }
}