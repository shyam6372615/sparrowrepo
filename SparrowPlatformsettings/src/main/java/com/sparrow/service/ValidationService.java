package com.sparrow.service;



import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.entity.SubjectGroupEntity;
@Service
public class ValidationService {
	public Response<?> validateForInstituteAdd(InstituteEntity instEntity){
		
		if(instEntity.getAffiliateOrg()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Affiloate Organisation!!",null);
		} 
		else if(instEntity.getAffiliationNo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Affilioation No!!",null);
		}
		else if(instEntity.getEmail()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the emailId!!",null);
		}
		else if(instEntity.getFkInstituteTypeId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the InstituteType!!",null);
		}
		else if(instEntity.getInstAddrs()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Address!!",null);
		}
		else if(instEntity.getInstituteIdPrefix()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Id prefix !!",null);
		}
		else if(instEntity.getInstituteName()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Name!!",null);
		}
		else if(instEntity.getInstLogo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Logo!!",null);
		}
		else if(instEntity.getPhNo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Contact no!!",null);
		}
		
		
		else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}

}
	public Response<?> validateForAcademicYearAdd(AcademicYearEntity academicYearEntity){
		if(academicYearEntity.getAcademicYear()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year!!",null);
		} 
		else if(academicYearEntity.getEndDate()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year End Date!!",null);
		}
		else if(academicYearEntity.getFkBatchYearId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the Batch Start Year!!",null);
		}else if(academicYearEntity.getStartDate()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year Start Date!!",null);
		}else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
		}
	public Response<?> validateForAcademicCourseAdd(AcademicCourseEntity academicCourseEntity){
		if(academicCourseEntity.getCourseDuration()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Course Duration!!",null);
		} 
		else if(academicCourseEntity.getCourseSemester()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Course Semester!!",null);
		}
		else if(academicCourseEntity.getEvenSemesterStDt()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the Even Semester Start Date!!",null);
		}else if(academicCourseEntity.getFkCourseLevelId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Course Level!!",null);
		}else if(academicCourseEntity.getFkDeptId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Department!!",null);
		}
		else if(academicCourseEntity.getFkProgramId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the Program!!",null);
		}else if(academicCourseEntity.getOddSemesterStDt()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Odd semester Start Date !!",null);
		}
		else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
		}

	public Response<?> validateForAcademicSubjectAdd(AcademicSubjectEntity academicSubjectEntity){
		if(academicSubjectEntity.getAcdmSubCode()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Code!!",null);
		} 
		else if(academicSubjectEntity.getAcdmSubTitle()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Tittle!!",null);
		}
		else if(academicSubjectEntity.getFkSubTypeId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select subject Type!!",null);
		}else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
		}
	public Response<?> validateForSubjectGroupAdd(SubjectGroupEntity subjectGroupEntity){
		if(subjectGroupEntity.getFkAcademicCourseId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Course Tittle!!",null);
		} 
		else if(subjectGroupEntity.getGroupTitle()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Group Tittle!!",null);
		}
		else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
		}
	public Response<?> validateForSubjectCategoryAdd(SubjectCategoryEntity subjectCategoryEntity){
		if(subjectCategoryEntity.getSubCategoryName()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Category Name!!",null);
		} 
		else if(subjectCategoryEntity.getSubType()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Type!!",null);
		}else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
}
	
}
