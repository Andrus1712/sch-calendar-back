package com.app.layer.business.mapper.persistence.repository;

import com.app.layer.domain.entity.ScheduleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTypeRepository extends JpaRepository<ScheduleTypeEntity, Long> {
}
