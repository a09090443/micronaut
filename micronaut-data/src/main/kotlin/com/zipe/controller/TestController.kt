package com.zipe.controller

import com.zipe.service.JdbcTestService
import com.zipe.service.TestService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
class TestController(
    private val testService: TestService,
    private val jdbcTestService: JdbcTestService
) {

    @Get("/HelloWorld")
    fun test():String {

        val bookList = jdbcTestService.findBookByName("Book1")
        println(bookList)
//        try {
//            testService.test("Hello")
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        testService.test2()
        return "test hello world"
    }
}
