package com.app.core.persistence.repository;

import com.app.core.domain.entity.ScheduleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTypeRepository extends JpaRepository<ScheduleTypeEntity, Long> {
}
