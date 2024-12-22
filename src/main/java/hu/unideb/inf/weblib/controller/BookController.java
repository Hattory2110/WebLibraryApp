package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public String books(){
        return "No books available!";
    }

    @GetMapping("/allbook")
    public List<BookEntity> getAllBook(){
        return repository.findAll();
    }


    @GetMapping("/book/{writer}")
    public List<BookEntity> getBookByWriter(@PathVariable String meret){
        List<BookEntity> meretValogatott = new ArrayList<>();
        meretValogatott = repository.findAll()
                .stream()
                .filter(x -> x.getWriter().equals(meret))
                .toList();
        return meretValogatott;
    }
    // /ruha?meret=M
    @GetMapping("/ruha")
    public List<BookEntity> getBookByWriterDb(@RequestParam String writer){
        return repository.findAllByWriter(writer);
    }

    @PostMapping("/savebook")
    public BookEntity saveBook(@RequestBody BookEntity entity) {
        return repository.save(entity);
    }

    @PutMapping("/updatebook")
    public BookEntity updateRuha(@RequestBody BookEntity entity){
        return repository.save(entity);
    }
    // /api/deleteruha?id=x
    @DeleteMapping("/deletebook")
    public void deleteRuha(@RequestParam Long lsz){
        repository.deleteById(lsz);
    }
}
