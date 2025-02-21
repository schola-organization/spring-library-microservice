package org.schola.spring.library.microservice.data.repository.mongo;

import org.schola.spring.library.microservice.data.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookMongoRepository extends MongoRepository<Book, String> {

    Optional<Book> findByName(String name);

    List<Book> findByAuthor(String author);

}
