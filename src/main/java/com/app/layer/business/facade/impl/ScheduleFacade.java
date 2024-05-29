package com.app.layer.business.facade.impl;

import com.app.layer.business.facade.IScheduleFacade;
import com.app.layer.business.mapper.ScheduleMapper;
import com.app.layer.business.service.impl.ScheduleServiceImpl;
import com.app.layer.domain.dto.ScheduleDTO;
import com.app.layer.domain.dto.ScheduleTypeDTO;
import com.app.layer.domain.entity.ScheduleEntity;
import com.app.layer.domain.entity.ScheduleTypeEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleFacade implements IScheduleFacade {

    private final ScheduleServiceImpl scheduleService;
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDTO> getAll() {
        var schedule = this.scheduleService.findAllSchedules();
        return schedule.stream().map(scheduleMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO getById(Long id) {
        return scheduleMapper.toDto(this.scheduleService.findScheduleById(id));
    }

    @Override
    public ScheduleDTO createNew(ScheduleDTO scheduleDTO) {
        var schedule = scheduleMapper.toEntity(scheduleDTO);
        var scheduleType = this.scheduleService.findScheduleTypeById(scheduleDTO.getScheduleTypeId());
        schedule.setScheduleType(scheduleType);
        var scheduleSaved = this.scheduleService.saveSchedule(schedule);
        return scheduleMapper.toDto(scheduleSaved);
    }

    @Override
    public ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO) {
        var scheduleSaved = this.scheduleService.updateSchedule(id, scheduleMapper.toEntity(scheduleDTO));
        return scheduleMapper.toDto(scheduleSaved);
    }

    @Override
    public void deleteById(Long id) {
        this.scheduleService.deleteSchedule(id);
    }

    @Override
    public ScheduleTypeDTO createNewType(ScheduleTypeDTO scheduleTypeDTO) {
        var scheduleType = scheduleMapper.toTypeEntity(scheduleTypeDTO);
        var scheduleTypeSaved = this.scheduleService.saveScheduleType(scheduleType);
        return scheduleMapper.toTypeDto(scheduleTypeSaved);
    }
}
