package com.app.layer.business.service.impl;

import com.app.layer.business.service.IScheduleService;
import com.app.layer.common.exception.ScheduleNotFoundException;
import com.app.layer.domain.entity.ScheduleEntity;
import com.app.layer.domain.entity.ScheduleTypeEntity;
import com.app.layer.business.mapper.persistence.dao.IScheduleDAO;
import com.app.layer.business.mapper.persistence.dao.IScheduleTypeDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements IScheduleService {

    private final IScheduleDAO scheduleDAO;
    private final IScheduleTypeDAO scheduleTypeDAO;

    @Override
    public List<ScheduleEntity> findAllSchedules() {
        return this.scheduleDAO.findAllSchedule();
    }

    @Override
    public ScheduleEntity findScheduleById(Long id) {
        return getSchedule(id);
    }


    private ScheduleEntity getSchedule(Long id) {
        var entity = this.scheduleDAO.findScheduleById(id);
        if (entity.isEmpty()) {
            throw new ScheduleNotFoundException();
        }
        return entity.get();
    }

    private ScheduleTypeEntity getScheduleType(Long id) {
        var entity = this.scheduleTypeDAO.findById(id);
        // Create new exception not found
        // throw new RuntimeException("Schedule type not found");
        return entity.orElse(null);
    }

    @Override
    public ScheduleEntity saveSchedule(ScheduleEntity request) {
        try {
            // Here entity can be init whit values that is necessaries
            // request.setScheduleType(1);
            return this.scheduleDAO.saveSchedule(request);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error while saving schedule");
        }
    }

    @Override
    public ScheduleEntity updateSchedule(Long id, ScheduleEntity request) {
        var optionalSchedule = this.scheduleDAO.findScheduleById(id);
        if (optionalSchedule.isPresent()) {
            ScheduleEntity currentSchedule = optionalSchedule.get();
            currentSchedule.setTitle(request.getTitle());
            currentSchedule.setDescription(request.getDescription());
            currentSchedule.setStartTime(request.getStartTime());
            currentSchedule.setEndTime(request.getEndTime());
            currentSchedule.setStatus(request.getStatus());
            // Type schedule
            var scheduleTypeEntity = this.scheduleTypeDAO.findById(request.getScheduleType().getId());
            scheduleTypeEntity.ifPresent(currentSchedule::setScheduleType);

            return this.scheduleDAO.updateSchedule(currentSchedule);
        } else {
            throw new UnsupportedOperationException("Error while updating schedule");
        }
    }

    @Override
    public void deleteSchedule(Long id) {
        try {
            var entity = this.scheduleDAO.findScheduleById(id);
            if (entity.isEmpty()) {
                throw new ScheduleNotFoundException();
            }
            this.scheduleDAO.deleteSchedule(id);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error while deleting schedule");
        }
    }

    @Override
    public ScheduleTypeEntity saveScheduleType(ScheduleTypeEntity request) {
        try {
            return this.scheduleTypeDAO.save(request);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error while saving type schedule");
        }
    }

    @Override
    public ScheduleTypeEntity findScheduleTypeById(Long id) {
        return getScheduleType(id);
    }
}
