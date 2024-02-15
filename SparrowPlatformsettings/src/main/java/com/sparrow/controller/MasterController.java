package com.sparrow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicBatchYearEntity;
import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.CourseLevelEntity;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.InstituteTypeEntity;
import com.sparrow.entity.ProgramEntity;
import com.sparrow.entity.SectionEntity;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.entity.SubjectGroupEntity;
import com.sparrow.service.DeactivationService;
import com.sparrow.service.MasterService;
import com.sparrow.service.ValidationService;


@RestController
@CrossOrigin
@RequestMapping("/sparrow")
public class MasterController {
	@Autowired
	private MasterService masterService;
	@Autowired
	private ValidationService validationService;
	@Autowired
	private DeactivationService deactivationService;
	
	//Institute Operation start
	
	
	@PostMapping("/addInstitute")
	public ResponseEntity<?> addInstitute(@RequestBody InstituteEntity instEntity){
		Response<?> validationResponse = validationService.validateForInstituteAdd(instEntity);
		if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
			Response<?> response = masterService.addInstitute(instEntity);
			return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
		} else {
			return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
		}
	}
	@GetMapping("/getAllInstitute")
	public ResponseEntity<?> getAllInstitute(){
		List<InstituteEntity> list= masterService.getAllInstitute();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}

	@GetMapping("/getInstituteById/{id}")
	public ResponseEntity<?> getInstituteById(@PathVariable("id") long instituteId) {
		Optional<?> instituteData = masterService.getInstituteById(instituteId);
		if (instituteData.isPresent()) {
			return new ResponseEntity<>(instituteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updateInstitute")
	public ResponseEntity<?> updateInstitute(@RequestBody InstituteEntity instEntity) {
		InstituteEntity instituteEntityData = masterService.updateInstitute(instEntity);
		if (instituteEntityData != null) {
			return new ResponseEntity<>(instituteEntityData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping("/getAllInstituteType")
	public ResponseEntity<?> getAllInstituteType(){
		List<InstituteTypeEntity> list= masterService.getAllInstituteType();
		return new ResponseEntity<>(list, HttpStatus.OK);
	
}
	//Institute Operation End
	
	//Academic year start
	
	@PostMapping("/addAcademicYear")
	public ResponseEntity<?> addAcademicYear(@RequestBody AcademicYearEntity academicYearEntity){
		Response<?> validationResponse = validationService.validateForAcademicYearAdd(academicYearEntity);
		if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
			Response<?> response = masterService.addAcademicYear(academicYearEntity);
			return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
		} else {
			return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
		}
	}
	@GetMapping("/getAllAcademicYear/{instituteId}")
	public ResponseEntity<?> getAllAcademicYear(@PathVariable("instituteId") Long instituteId){
		List<AcademicYearEntity> list= masterService.getAllAcademicYear( instituteId);
		return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping("/getAcademicYearById/{instituteId}/{id}")
public ResponseEntity<?> getAcademicYearById(@PathVariable("instituteId") long instituteId,@PathVariable("id") long academicId) {
	AcademicYearEntity academicYearData = masterService.getAcademicYearById(instituteId, academicId);
	if (academicYearData!=null) {
		return new ResponseEntity<>(academicYearData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@PutMapping("/updateAcademicYear")
public ResponseEntity<?> updateAcademicYear(@RequestBody AcademicYearEntity academicYearEntity) {
	AcademicYearEntity academicYearData = masterService.updateAcademicYear(academicYearEntity);
	if (academicYearData != null) {
		return new ResponseEntity<>(academicYearData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
//Academic Year End


@GetMapping("/getAllAcademicBatchYear")// to be discuss
public ResponseEntity<?> getAllAcademicBatchYear(){
	List<AcademicBatchYearEntity> list= masterService.getAllAcademicBatchYear();
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@PostMapping("/addAcademicCourse")
public ResponseEntity<?> addAcademicCourse(@RequestBody AcademicCourseEntity academicCourseEntity){
	Response<?> validationResponse = validationService.validateForAcademicCourseAdd(academicCourseEntity);
	if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
		Response<?> response = masterService.addAcademicCourse(academicCourseEntity);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	} else {
		return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
	}
}
@GetMapping("/getAllAcademicCourse/{instituteId}")
public ResponseEntity<?> getAllAcademicCourse(@PathVariable("instituteId") Long instituteId){
	List<AcademicCourseEntity> list= masterService.getAllAcademicCourse(instituteId);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("/getAcademicCourseById/{instituteId}/{id}")
public ResponseEntity<?> getAcademicCourseById(@PathVariable("instituteId") long instituteId,@PathVariable("id") long academicCourseId) {
	AcademicCourseEntity academicCourseData = masterService.getAcademicCourseById(instituteId, academicCourseId);
	if (academicCourseData!=null) {
		return new ResponseEntity<>(academicCourseData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@GetMapping("/get/section/by/{departmentid}")
public ResponseEntity<?> getAllSectionByDepartmetId(@PathVariable("departmentid") Long departmentid){
	List<SectionEntity> list= masterService.getAllSectionByDepartment(departmentid);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("get/program/by/{levelId}")
public ResponseEntity<?> getSbuByStateId(@PathVariable("levelId") Long LevelId) {
	List<ProgramEntity> response = masterService.getAllProgramByLevelId(LevelId);
	return new ResponseEntity<>(response, HttpStatus.OK);
}
@GetMapping("/getAllCourseLevel")
public ResponseEntity<?> getAllCourseLevel(){
	List<CourseLevelEntity> list= masterService.getAllCourseLevel();
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping("/get/department/by/{programId}")
public ResponseEntity<?> getAllDepartment(@PathVariable("programId") Long programId){
	List<DepartmentEntity> list= masterService.getAllDepartmentByProgramId(programId);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@PutMapping("/updateAcademicCourse")
public ResponseEntity<?> updateAcademicCourse(@RequestBody AcademicCourseEntity academicCourseEntity) {
	AcademicCourseEntity academicCourseData = masterService.updateAcademicCourse(academicCourseEntity);
	if (academicCourseData != null) {
		return new ResponseEntity<>(academicCourseData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@PostMapping("/addAcademicSubject")
public ResponseEntity<?> addAcademicSubject(@RequestBody AcademicSubjectEntity academicSubjectEntity){
	Response<?> validationResponse = validationService.validateForAcademicSubjectAdd(academicSubjectEntity);
	if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
		Response<?> response = masterService.addAcademicSubject(academicSubjectEntity);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	} else {
		return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
	}
}
@GetMapping("/getAllAcademicSubject/{instituteId}")
public ResponseEntity<?> getAllAcademicSubject(@PathVariable("instituteId") Long instituteId){
	List<AcademicSubjectEntity> list= masterService.getAllAcademicSubjects(instituteId);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("/getAcademicSubjectById/{instituteId}/{id}")
public ResponseEntity<?> getAcademicSubjectById(@PathVariable("instituteId") Long instituteId,@PathVariable("id") long academicSubjectId) {
	AcademicSubjectEntity academicSubjectData = masterService.getAcademicSubjectById(instituteId,academicSubjectId );
	if (academicSubjectData!=null) {
		return new ResponseEntity<>(academicSubjectData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@PutMapping("/updateAcademicSubject")
public ResponseEntity<?> updateAcademicSubject(@RequestBody AcademicSubjectEntity academicSubjectEntity) {
	AcademicSubjectEntity academicSubjectData = masterService.updateAcademicSubject(academicSubjectEntity);
	if (academicSubjectData != null) {
		return new ResponseEntity<>(academicSubjectData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
@PostMapping("/addSubjectGroup")
public ResponseEntity<?> addSubjectGroup(@RequestBody SubjectGroupEntity subjectGroupEntity){
	Response<?> validationResponse = validationService.validateForSubjectGroupAdd(subjectGroupEntity);
	if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
		Response<?> response = masterService.addSubjectGroup(subjectGroupEntity);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	} else {
		return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
	}
}
@GetMapping("/getAllSubjectGroup/{instituteId}")
public ResponseEntity<?> getAllSubjectGroup(@PathVariable("instituteId") Long instituteId){
	List<SubjectGroupEntity> list= masterService.getAllSubjectGroup(instituteId);
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@PostMapping("/addSubjectCategory")
public ResponseEntity<?> addSubjectCategory(@RequestBody SubjectCategoryEntity subjectCategoryEntity){
	Response<?> validationResponse = validationService.validateForSubjectCategoryAdd(subjectCategoryEntity);
	if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
		Response<?> response = masterService.addSubjectCategory(subjectCategoryEntity);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	} else {
		return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
	}
}
@GetMapping("/getAllSubjectCategory/{instituteId}")
public ResponseEntity<?> getAllSubjectCategory(@PathVariable("instituteId") Long instituteId){
	List<SubjectCategoryEntity> list= masterService.getAllSubjectCategory(instituteId);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
}


