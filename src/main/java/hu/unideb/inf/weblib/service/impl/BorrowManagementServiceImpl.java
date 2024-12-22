package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.data.entities.BorrowEntity;
import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.data.repositories.BookRepository;
import hu.unideb.inf.weblib.data.repositories.BorrowRepository;
import hu.unideb.inf.weblib.data.repositories.ReaderRepository;
import hu.unideb.inf.weblib.service.BorrowManagementService;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import hu.unideb.inf.weblib.service.mapper.BorrowMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowManagementServiceImpl implements BorrowManagementService {

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BorrowMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BorrowDTO save(BorrowDTO dto) {
        BorrowEntity borrowEntity = mapper.borrowDtoToEntity(dto);
        borrowEntity = borrowRepository.save(borrowEntity);
        return mapper.borrowEntityToDto(borrowEntity);
    }

    @Override
    public BorrowDTO getById(Long id) {
        BorrowEntity entity = borrowRepository.getReferenceById(id);
        BorrowDTO dto = new BorrowDTO();
        dto = mapper.borrowEntityToDto(entity);
        return dto;
    }

    @Override
    public List<BorrowDTO> findAll() {
        return mapper.borrowEntityListToDtoList(borrowRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        borrowRepository.deleteById(id);
    }

    @Override
    public BorrowDTO update(BorrowDTO dto) {
        return save(dto);
    }

    @Override
    public List<ReaderDTO> borrowingReaders() {
//        List<BorrowEntity> borrowings = borrowRepository.findAll();
//        List<ReaderEntity> readers = new ArrayList<>();
//
//        for (BorrowEntity borrow:borrowings) {
//            readers.add(borrow.)
//        }

        return List.of();
    }

    @Override
    public List<BookDTO> borrowedBooks() {
        return null;
    }

    @Override
    public List<BorrowDTO> borrowedBook(BookDTO bookDTO) {
        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);

        List<BorrowEntity> borrowEntities = borrowRepository.findByBookEntitiesContains(bookEntity);

        return mapper.borrowEntityListToDtoList(borrowEntities);
    }
}
