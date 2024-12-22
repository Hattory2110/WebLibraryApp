package hu.unideb.inf.weblib.service.mapper;

import hu.unideb.inf.weblib.data.entities.BorrowEntity;
import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    @Mapping(target = "osz", source = "osz")
    BorrowDTO readerEntityToDto(ReaderEntity entity);
    List<ReaderDTO> readerEntityListToDtoList(List<ReaderEntity> entities);
    ReaderEntity readerDtoToEntity(ReaderDTO dto);
    List<ReaderEntity> readerDtoListToEntityList(List<ReaderDTO> dtos);
}
