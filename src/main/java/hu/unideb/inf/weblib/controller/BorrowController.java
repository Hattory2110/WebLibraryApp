package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.service.BorrowManagementService;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    BorrowManagementService service;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/borrows")
    public List<BorrowDTO> getAllReader(){
        return service.findAll();
    }

    @GetMapping("/borrow")
    public BorrowDTO getReaderByOsz(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping("/save_borrow")
    public BorrowDTO saveReader(@RequestBody BorrowDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/update_borrow")
    public BorrowDTO updateReader(@RequestBody BorrowDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/delete_borrow")
    public void deleteReader(@RequestParam Long id){
        service.deleteById(id);
    }

    @GetMapping("/borrowed_book")
    public List<BorrowDTO> getBorrowContainingBook(@RequestBody BookDTO bookDTO) {
        return service.borrowedBook(bookDTO);
    }
}
