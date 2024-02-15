package com.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "spr_adminstrator")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminstratorEntity extends BaseEntity {
	 

	/**
	 * 
	 */
	private static final long serialVersionUID = -4344794791770265408L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adminstrator_id")
	private Long adminstratorId;
	@Column(name="adminstrator_name")
	private String adminStratorName;
	@Column(name="designation")
	private String designation;
	@OneToOne
	@JoinColumn(name="fk_department_id")
	private DepartmentEntity fkDeptId;
	@Column(name="is_active")
	private Boolean isActive;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	

}
