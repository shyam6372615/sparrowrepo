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
@Table(name = "spr_academic_courses")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AcademicCourseEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="academic_course_id")
	
	private Long academicCouirseId;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@OneToOne
	@JoinColumn(name="fk_course_level_id")
	private CourseLevelEntity fkCourseLevelId;
	@OneToOne
	@JoinColumn(name="fk_course_program_id")
	private ProgramEntity fkProgramId;
	@OneToOne
	@JoinColumn(name="fk_course_dept_id")
	private DepartmentEntity fkDeptId;
	@OneToOne
	@JoinColumn(name="fk_course_sec_id")
	private SectionEntity fkSectionId;
	@Column(name="course_duration")
	private String courseDuration;
	@Column(name="section_students")
	private Integer sectionStudents;
	@Column(name="course_title")
	private String courseTitle;
	@Column(name="course_semester")
	private String courseSemester;
	@Column(name="odd_sem_st_dt")
	private String oddSemesterStDt;
	@Column(name="even_sem_st_dt")
	private String evenSemesterStDt;
	@Column(name="is_active")
	private Boolean isActive=true;
	

}
