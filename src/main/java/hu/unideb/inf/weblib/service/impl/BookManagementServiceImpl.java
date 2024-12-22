package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.data.repositories.BookRepository;
import hu.unideb.inf.weblib.service.BookManagementService;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookManagementServiceImpl implements BookManagementService {

    @Autowired
    BookRepository repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BookDTO save(BookDTO dto) {
        BookEntity bookEntity = modelMapper.map(dto, BookEntity.class);
        bookEntity = repo.save(bookEntity);
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    @Override
    public List<BookDTO> findAll() {
        List<BookEntity> list = repo.findAll();
        List<BookDTO> dtos = new ArrayList<>();
        dtos = modelMapper.map(list, new TypeToken<List<BookDTO>>(){}.getType());
        return dtos;
    }

    @Override
    public BookDTO findByLsz(Long lsz) {
        BookEntity entity = repo.findById(lsz).orElse(null);
        BookDTO dto = new BookDTO();

        dto.setLsz(entity.getLsz());
        dto.setTitle(entity.getTitle());
        dto.setGenre(entity.getGenre());
        dto.setWriter(entity.getWriter());
        dto.setPubisher(entity.getPubisher());
        dto.setDate(entity.getDate());
        return dto;
    }

    @Override
    public void delete(Long lsz) {
        BookEntity entity = repo.findById(lsz).orElse(null);
        repo.delete(entity);
    }

    @Override
    public BookDTO update(BookDTO dto) {
        return save(dto);
    }

    @Override
    public List<BookDTO> bookByWriter(String writer) {
        List<BookEntity> bookSorted = new ArrayList<>();
        bookSorted = repo.findAll()
                .stream()
                .filter(x -> x.getWriter().equals(writer))
                .toList();
        return modelMapper.map(bookSorted, new TypeToken<List<BookDTO>>(){}.getType());
    }

    @Override
    public List<BookDTO> bookByWriterDb(String writer) {
        List<BookEntity> bookSorted = repo.findAllByWriter(writer);

        return modelMapper.map(bookSorted, new TypeToken<List<BookDTO>>(){}.getType());
    }

    @Override
    public List<BookDTO> bookByParams(String title, String genre, String writer, String publisher, Date date) {
        List<BookEntity> bookSorted = repo.findAllByTitleAndGenreAndWriterAndPubisherAndDate(title, genre, writer, publisher, date);

        return modelMapper.map(bookSorted, new TypeToken<List<BookDTO>>(){}.getType());
    }
}
