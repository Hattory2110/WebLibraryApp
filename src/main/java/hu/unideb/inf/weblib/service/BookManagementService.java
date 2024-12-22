package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.service.dto.BookDTO;
import java.util.List;

public interface BookManagementService {

    BookDTO save(BookDTO dto);
    List<BookDTO> findAll();
    BookDTO findByLsz(Long lsz);
    void delete(Long lsz);
    BookDTO update(BookDTO dto);
}
