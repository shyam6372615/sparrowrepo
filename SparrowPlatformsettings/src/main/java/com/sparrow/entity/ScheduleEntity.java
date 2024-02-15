package com.sparrow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="spr_view_schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="view_schedule_id")
private Long viewScheduleId;
@JsonIgnore
@JoinColumn(name="fk_institute_id")
@OneToOne
private InstituteEntity fkInstituteId;

@Column(name="view_schedule_name")
private String viewScheduleName;

@Column(name="is_active")
private Boolean isActive;



}
