package com.sparrow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparrow.entity.ScheduleEntity;

public interface ScheduleRepo extends JpaRepository<ScheduleEntity,Long> {

}
