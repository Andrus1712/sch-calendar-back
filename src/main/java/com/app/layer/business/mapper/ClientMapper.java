package com.app.layer.business.mapper;

import com.app.layer.domain.dto.ClientDTO;
import com.app.layer.domain.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toClientDTO(ClientEntity clientEntity);

    ClientEntity toClientEntity(ClientDTO clientDTO);
}
