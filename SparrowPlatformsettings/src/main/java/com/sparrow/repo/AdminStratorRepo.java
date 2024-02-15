package com.sparrow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparrow.entity.AdminstratorEntity;

public interface AdminStratorRepo extends JpaRepository<AdminstratorEntity, Long> {

}
