package com.app.core.business.mapper;

import com.app.core.domain.dto.ClientDTO;
import com.app.core.domain.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toClientDTO(ClientEntity clientEntity);

    ClientEntity toClientEntity(ClientDTO clientDTO);
}
