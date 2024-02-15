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
@Table(name = "spr_academic_subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AcademicSubjectEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5657455422979875546L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="academic_subject_id")
	private Long acdmSubId;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@Column(name="academic_sub_title")
	private String acdmSubTitle;
	@Column(name="academic_sub_code")
	private String acdmSubCode;
	@OneToOne
	@JoinColumn(name="fk_subject_type_id")
	private SubjectTypeEntity fkSubTypeId;
	@Column(name="is_active")
	private Boolean isActive=true;
	

}
