package org.schola.spring.library.microservice.data.service

import org.schola.spring.library.microservice.data.model.BOOK_KEY
import org.schola.spring.library.microservice.data.model.Book
import org.schola.spring.library.microservice.data.repository.mongo.BookMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService {

    @Autowired
    private lateinit var mongo: BookMongoRepository

    @CachePut(value = [BOOK_KEY], key = "#book.id")
    fun save(book: Book) {
        mongo.save(book)
    }

    @Cacheable(value = [BOOK_KEY], key = "#id")
    fun getWithIdentifier(id: String): Book = mongo.findById(id).get()

    @Cacheable(value = [BOOK_KEY], key = "#name")
    fun getWithName(name: String): Book = mongo.findByName(name).get()

    @Cacheable(value = [BOOK_KEY], key = "#author")
    fun getByAuthor(author: String): List<Book> = mongo.findByAuthor(author);

    @Cacheable(value = [BOOK_KEY])
    fun getAll(pageable: Pageable): List<Book> = mongo.findAll(pageable).content

    @CacheEvict(value = [BOOK_KEY], key = "#id")
    fun delete(id: String) = mongo.deleteById(id)

}