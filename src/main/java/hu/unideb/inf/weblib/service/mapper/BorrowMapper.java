package hu.unideb.inf.weblib.service.mapper;

import hu.unideb.inf.weblib.data.entities.BorrowEntity;
import hu.unideb.inf.weblib.service.dto.BorrowDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowMapper {

    @Mapping(target = "id", source = "id")
    BorrowDTO borrowEntityToDto(BorrowEntity entity);
    List<BorrowDTO> borrowEntityListToDtoList(List<BorrowEntity> entities);
    BorrowEntity borrowDtoToEntity(BorrowDTO dto);
    List<BorrowEntity> borrowDtoListToEntityList(List<BorrowDTO> dtos);
}
