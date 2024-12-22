package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;

import java.util.List;
public interface BorrowManagementService {

    BorrowDTO save(BorrowDTO dto);
    BorrowDTO getById(Long id);
    List<BorrowDTO> findAll();
    void deleteById(Long id);

    BorrowDTO update(BorrowDTO dto);

    List<ReaderDTO> borrowingReaders();

    List<BookDTO> borrowedBooks();

    List<BorrowDTO> borrowedBook(BookDTO bookDTO);
}
