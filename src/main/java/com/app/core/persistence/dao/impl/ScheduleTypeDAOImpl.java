package com.app.core.persistence.dao.impl;

import com.app.core.domain.entity.ScheduleTypeEntity;
import com.app.core.persistence.dao.IScheduleTypeDAO;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ScheduleTypeDAOImpl implements IScheduleTypeDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Optional<ScheduleTypeEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(ScheduleTypeEntity.class, id));
    }

    @Override
    @Transactional
    public ScheduleTypeEntity save(ScheduleTypeEntity typeEntity) {
        this.entityManager.persist(typeEntity);
        this.entityManager.flush();
        return typeEntity;
    }
}
