package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.data.entities.BorrowEntity;
import hu.unideb.inf.weblib.data.repositories.BorrowRepository;
import hu.unideb.inf.weblib.service.BorrowService;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import hu.unideb.inf.weblib.service.mapper.BorrowMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowRepository repo;

    @Autowired
    BorrowMapper mapper;

    @Override
    public BorrowDTO getById(Long id) {
        BorrowEntity entity = repo.getReferenceById(id);
        BorrowDTO dto = new BorrowDTO();
        dto = mapper.borrowEntityToDto(entity);
        return dto;
    }

    @Override
    public List<BorrowDTO> findAll() {
        return mapper.borrowEntityListToDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
