package com.app.layer.business.mapper.persistence.dao;

import com.app.layer.domain.entity.ScheduleEntity;

import java.util.List;
import java.util.Optional;

public interface IScheduleDAO {
    List<ScheduleEntity> findAllSchedule();

    Optional<ScheduleEntity> findScheduleById(Long id);

    ScheduleEntity saveSchedule(ScheduleEntity schedule);

    ScheduleEntity updateSchedule(ScheduleEntity schedule);

    void deleteSchedule(Long id);
}
