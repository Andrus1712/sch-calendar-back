package com.app.layer.business.mapper.persistence.dao.impl;

import com.app.layer.domain.entity.ScheduleEntity;
import com.app.layer.business.mapper.persistence.dao.IScheduleDAO;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ScheduleDAOImpl implements IScheduleDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<ScheduleEntity> findAllSchedule() {
        return this.entityManager.createQuery("SELECT s FROM ScheduleEntity s", ScheduleEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ScheduleEntity> findScheduleById(Long id) {
        return Optional.ofNullable(this.entityManager.find(ScheduleEntity.class, id));
    }

    @Override
    @Transactional
    public ScheduleEntity saveSchedule(ScheduleEntity schedule) {
        this.entityManager.persist(schedule);
        this.entityManager.flush();
        return schedule;
    }

    @Override
    @Transactional
    public ScheduleEntity updateSchedule(ScheduleEntity schedule) {
        return this.entityManager.merge(schedule);
    }

    @Override
    @Transactional
    public void deleteSchedule(Long id) {
        this.entityManager.remove(this.entityManager.find(ScheduleEntity.class, id));
    }
}
