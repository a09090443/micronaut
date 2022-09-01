package com.zipe.controller

import com.zipe.service.TestService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
class TestController(
    private val testService: TestService
) {

    @Get("/HelloWorld")
    fun test():String {

        val bookList = testService.findBooks()
        println(bookList)
        try {
            testService.test("Hello")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        testService.test2()
        return "test hello world"
    }
}
