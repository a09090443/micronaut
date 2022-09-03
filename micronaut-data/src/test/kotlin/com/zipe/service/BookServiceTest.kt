package com.zipe.service

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class BookServiceTest(
    private val bookService: BookService
) {

    @Test
    fun `test find book by name`(){
        val book = bookService.findBookBySn("1006")
        println(book)
    }
}