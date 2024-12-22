package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import java.util.List;
public interface BorrowService {

    BorrowDTO getById(Long id);
    List<BorrowDTO> findAll();
    void deleteById(Long id);


}
