package com.zipe

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.zipe")
        .start()
}

