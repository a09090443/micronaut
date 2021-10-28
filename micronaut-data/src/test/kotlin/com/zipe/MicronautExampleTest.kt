package com.zipe

import com.zipe.service.TestService
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.micronaut.transaction.annotation.TransactionalAdvice
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@MicronautTest(transactional = false)
class MicronautExampleTest {

    @Inject
    lateinit var testService: TestService

    @Test
    fun testItWorks() {
        try {
            testService.test("Hello")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        testService.test2()
    }

}
