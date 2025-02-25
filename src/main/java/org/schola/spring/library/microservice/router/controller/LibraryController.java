package org.schola.spring.library.microservice.router.controller;

import org.schola.spring.library.microservice.data.model.Book;
import org.schola.spring.library.microservice.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private BookService service;

    @PostMapping("/books")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        service.save(book);
        return ResponseEntity.ok("Livro salvo com sucesso!");
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.of(Optional.of(service.getWithIdentifier(id)));
    }

    @GetMapping("/books/name/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable String name) {
        final Book book = service.getWithName(name);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/books/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        final List<Book> books = service.getByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Book> books = service.getAll(pageable);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Book deleted");
    }
}
