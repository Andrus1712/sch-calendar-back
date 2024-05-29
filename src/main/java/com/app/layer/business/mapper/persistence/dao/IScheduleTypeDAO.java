package com.app.layer.business.mapper.persistence.dao;

import com.app.layer.domain.entity.ScheduleTypeEntity;

import java.util.Optional;

public interface IScheduleTypeDAO {
    Optional<ScheduleTypeEntity> findById(Long id);

    ScheduleTypeEntity save(ScheduleTypeEntity request);
}
