package com.zipe.repository

import com.zipe.entity.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository : CrudRepository<Book, Long>
