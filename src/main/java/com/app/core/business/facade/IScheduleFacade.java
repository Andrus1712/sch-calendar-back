package com.app.core.business.facade;

import com.app.core.domain.dto.ScheduleDTO;
import com.app.core.domain.dto.ScheduleTypeDTO;

import java.util.List;

public interface IScheduleFacade {

    List<ScheduleDTO> getAll();

    ScheduleDTO getById(Long id);

    ScheduleDTO createNew(ScheduleDTO scheduleDTO);

    ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO);

    void deleteById(Long id);

    ScheduleTypeDTO createNewType(ScheduleTypeDTO scheduleTypeDTO);
}
