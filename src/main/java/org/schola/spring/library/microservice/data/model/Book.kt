package org.schola.spring.library.microservice.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.redis.core.RedisHash

const val BOOK_KEY = "library.book"

@Document(BOOK_KEY)
@RedisHash(BOOK_KEY)
data class Book(

    @Id
    val id: String,

    val name: String,
    val author: String,
    val description: String,

    val tags: List<String>,

    val rented: Boolean
)
