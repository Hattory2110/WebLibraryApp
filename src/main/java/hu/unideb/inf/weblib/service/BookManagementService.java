package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.service.dto.BookDTO;

import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookManagementService {

    BookDTO save(BookDTO dto);
    List<BookDTO> findAll();
    BookDTO findByLsz(Long lsz);
    void delete(Long lsz);
    BookDTO update(BookDTO dto);

    List<BookDTO> bookByWriter(String writer);
    List<BookDTO> bookByWriterDb(String writer);
    List<BookDTO> bookByParams(String title, String genre, String writer, String publisher, Date date);
}
