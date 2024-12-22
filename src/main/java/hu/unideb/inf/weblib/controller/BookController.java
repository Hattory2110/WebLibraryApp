package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.service.BookManagementService;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookManagementService service;

    @GetMapping("/books")
    public String books(){
        return "No books available!";
    }

    @GetMapping("/allbook")
    public List<BookDTO> getAllBook(){
        return service.findAll();
    }


    @GetMapping("/book/{writer}")
    public List<BookDTO> getBookByWriter(@PathVariable String writer){
        List<BookDTO> bookSorted = new ArrayList<>();
        bookSorted = service.findAll()
                .stream()
                .filter(x -> x.getWriter().equals(writer))
                .toList();
        return bookSorted;
    }


    @GetMapping("/book")
    public List<BookDTO> getBookByWriterDb(@RequestParam String writer){
        return service.bookByWriterDb(writer);
    }

    @GetMapping("/filteredbook")
    public List<BookDTO> getFilteredBook(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) String genre,
                                            @RequestParam(required = false) String writer,
                                            @RequestParam(required = false) String publisher,
                                            @RequestParam(required = false) Integer date){
        return service.findAll().stream()
                .filter(x -> title == null || x.getTitle().equals(title))
                .filter(x -> genre == null || x.getGenre().equals(genre))
                .filter(x -> writer == null || x.getWriter().equals(writer))
                .filter(x -> publisher == null || x.getPubisher().equals(publisher))
                .toList();
    }

    @PostMapping("/savebook")
    public BookDTO saveBook(@RequestBody BookDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/updatebook")
    public BookDTO updateRuha(@RequestBody BookDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/deletebook")
    public void deleteRuha(@RequestParam Long lsz){
        service.delete(lsz);
    }
}
