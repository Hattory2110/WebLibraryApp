package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.data.repositories.ReaderRepository;
import hu.unideb.inf.weblib.service.ReaderManagementService;
import hu.unideb.inf.weblib.service.dto.BookDTO;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReaderManagementServiceImpl implements ReaderManagementService {

    @Autowired
    ReaderRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public ReaderDTO save(ReaderDTO dto) {
        ReaderEntity readerEntity = mapper.map(dto, ReaderEntity.class);
        readerEntity = repo.save(readerEntity);
        return mapper.map(readerEntity, ReaderDTO.class);
    }

    @Override
    public List<ReaderDTO> findAll() {
        List<ReaderEntity> list = repo.findAll();
        List<ReaderDTO> dtos = new ArrayList<>();

        dtos = mapper.map(list, new TypeToken<List<ReaderDTO>>(){}.getType());
        return dtos;
    }

    @Override
    public ReaderDTO findByOsz(Long osz) {
        ReaderEntity entity = repo.findById(osz).orElse(null);
        ReaderDTO dto = new ReaderDTO();

        dto.setOsz(entity.getOsz());
        dto.setEmail(entity.getEmail());
        dto.setJelszo(entity.getJelszo());
        dto.setNev(entity.getNev());
        dto.setNem(entity.getNem());
        dto.setSzuldate(entity.getSzuldate());
        dto.setTelefon(entity.getTelefon());
        dto.setCim(entity.getCim());
        dto.setJogosultsag(entity.getCim());

        return dto;
    }

    @Override
    public List<ReaderDTO> findAllByNameOrd(String nev) {
        List<ReaderEntity> list = repo.findAllByNevOrderBySzuldate(nev);

        List<ReaderDTO> dtos = new ArrayList<>();

        dtos = mapper.map(list, new TypeToken<List<ReaderDTO>>(){}.getType());
        return dtos;
    }

    @Override
    public void delete(Long osz) {
        ReaderEntity entity = repo.findById(osz).orElse(null);
        repo.delete(entity);
    }

    @Override
    public ReaderDTO update(ReaderDTO dto) {
        return save(dto);
    }

}
