package com.app.layer.business.mapper;

import com.app.layer.domain.dto.ScheduleDTO;
import com.app.layer.domain.dto.ScheduleTypeDTO;
import com.app.layer.domain.entity.ScheduleEntity;
import com.app.layer.domain.entity.ScheduleTypeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(source = "scheduleTypeId", target = "scheduleType.id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    ScheduleEntity toEntity(ScheduleDTO dto);

    @Mapping(source = "scheduleType.id", target = "scheduleTypeId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(source = "scheduleType.typeName", target = "scheduleTypeDescription", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    ScheduleDTO toDto(ScheduleEntity scheduleEntity);

    ScheduleTypeEntity toTypeEntity(ScheduleTypeDTO dto);

    ScheduleTypeDTO toTypeDto(ScheduleTypeEntity dto);
}
