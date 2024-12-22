package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public String books(){
        return "No books available!";
    }

    @PostMapping("/savebook")
    public BookEntity saveBook(@RequestBody BookEntity entity) {
        return repository.save(entity);
    }
}
