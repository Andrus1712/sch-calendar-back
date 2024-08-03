package com.app.core.persistence.dao;

import com.app.core.domain.entity.ScheduleTypeEntity;

import java.util.Optional;

public interface IScheduleTypeDAO {
    Optional<ScheduleTypeEntity> findById(Long id);

    ScheduleTypeEntity save(ScheduleTypeEntity request);
}
