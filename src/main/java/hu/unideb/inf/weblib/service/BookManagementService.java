package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.service.dto.BookDTO;

import java.util.List;

public interface BookManagementService {

    BookDTO save(BookDTO dto);
    List<BookDTO> findAll();
    BookDTO findByLsz(Long lsz);
    void delete(Long lsz);
    BookDTO update(BookDTO dto);

    List<BookDTO> bookByWriter(String writer);
    List<BookDTO> bookByWriterDb(String writer);

    List<BookDTO> bookByTitleDb(String title);

    List<BookDTO> bookByPublisherDb(String publisher);

    List<BookDTO> bookByGenreDb(String genre);

    List<BookDTO> bookByParams(String title, String genre, String writer, String publisher);
}
