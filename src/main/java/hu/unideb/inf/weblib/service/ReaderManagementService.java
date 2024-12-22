package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.service.dto.BookDTO;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;

import java.util.List;

public interface ReaderManagementService {

    ReaderDTO save(ReaderDTO dto);
    List<ReaderDTO> findAll();

    List<ReaderDTO> findAllByNameOrd(String name);
    ReaderDTO findByOsz(Long osz);
    void delete(Long osz);
    ReaderDTO update(ReaderDTO dto);


}
