package com.app.layer.business.service;

import com.app.layer.domain.entity.ScheduleEntity;
import com.app.layer.domain.entity.ScheduleTypeEntity;

import java.util.List;

public interface IScheduleService {
    List<ScheduleEntity> findAllSchedules();

    ScheduleEntity findScheduleById(Long id);

    ScheduleEntity saveSchedule(ScheduleEntity request);

    ScheduleEntity updateSchedule(Long id, ScheduleEntity request);

    void deleteSchedule(Long id);

    ScheduleTypeEntity saveScheduleType(ScheduleTypeEntity request);

    ScheduleTypeEntity findScheduleTypeById(Long id);
}
