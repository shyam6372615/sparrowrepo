package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.CourseLevelEntity;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.ProgramEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {
	@Query(value = "SELECT * FROM spr_department WHERE is_active=1 AND fk_program_id = :#{#programId} ", nativeQuery = true)
	List<DepartmentEntity> findAllDepartmentByProgramId(@Param("programId") Long programId);
	
	@Query(value = "SELECT department_name From spr_department WHERE is_active=1 AND department_id = :#{#departmentId} ", nativeQuery = true)
    String findDepartmentNameById(@Param("departmentId") Long departmentId);
}
