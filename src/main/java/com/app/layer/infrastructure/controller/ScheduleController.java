package com.app.layer.infrastructure.controller;

import com.app.layer.business.facade.IScheduleFacade;
import com.app.layer.domain.dto.ScheduleDTO;
import com.app.layer.domain.dto.ScheduleTypeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final IScheduleFacade scheduleFacade;

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> findAll() {
        return new ResponseEntity<>(this.scheduleFacade.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.scheduleFacade.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return new ResponseEntity<>(this.scheduleFacade.createNew(scheduleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO) {
        return new ResponseEntity<>(this.scheduleFacade.updateSchedule(id, scheduleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable Long id) {
        this.scheduleFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save-type")
    public ResponseEntity<ScheduleTypeDTO> saveScheduleType(@RequestBody ScheduleTypeDTO scheduleTypeDTO) {
        return new ResponseEntity<>(this.scheduleFacade.createNewType(scheduleTypeDTO), HttpStatus.CREATED);
    }
}
