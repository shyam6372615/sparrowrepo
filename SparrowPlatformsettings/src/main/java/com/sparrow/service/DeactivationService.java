package com.sparrow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.repo.AcademicCourseRepo;
import com.sparrow.repo.AcademicSubjectRepo;
import com.sparrow.repo.AcademicYearRepo;
import com.sparrow.repo.InstituteRepo;
import com.sparrow.repo.SubjectCategoryRepo;
@Service
public class DeactivationService {
	@Autowired
	private InstituteRepo instRepo;
	@Autowired
	private AcademicYearRepo acdmRepo;
	@Autowired
	private AcademicCourseRepo acdmCourseRepo;
	@Autowired
	private AcademicSubjectRepo acdmSubRepo;
	@Autowired
	private SubjectCategoryRepo subCategoryrepo;
	
	
	public Response<?> deactivateInstitute(Long id) {
	    Optional<InstituteEntity> existingInstData = instRepo.findById(id);

	    if (existingInstData.isPresent()) {
	    	existingInstData.get().setIsActive(false);
	    	instRepo.save(existingInstData.get());
	        return new Response<>(HttpStatus.OK.value(), "Institute Deactivated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Institute not found", null);
	    }
	}
	public Response<?> deactivatAcademicYear(Long id) {
	    Optional<AcademicYearEntity> existingacdmYearData = acdmRepo.findById(id);

	    if (existingacdmYearData.isPresent()) {
	    	existingacdmYearData.get().setIsActive(false);
	    	acdmRepo.save(existingacdmYearData.get());
	        return new Response<>(HttpStatus.OK.value(), "Academic Year Deactivated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Year  not found", null);
	    }
	}
	public Response<?> deactivateAcademicCourse(Long id) {
	    Optional<AcademicCourseEntity> existingCourseData = acdmCourseRepo.findById(id);

	    if (existingCourseData.isPresent()) {
	    	existingCourseData.get().setIsActive(false);
	    	acdmCourseRepo.save(existingCourseData.get());
	        return new Response<>(HttpStatus.OK.value(), "Academic Course Deactivated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Course not found", null);
	    }
	}
	public Response<?> deactivateAcademicSubject(Long id) {
	    Optional<AcademicSubjectEntity> existingSubjectData = acdmSubRepo.findById(id);

	    if (existingSubjectData.isPresent()) {
	    	existingSubjectData.get().setIsActive(false);
	    	acdmSubRepo.save(existingSubjectData.get());
	        return new Response<>(HttpStatus.OK.value(), "Academic Subject Deactivated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Subject not found", null);
	    }
	}
	public Response<?> deactivateSubjectCategory(Long id) {
	    Optional<SubjectCategoryEntity> existingData = subCategoryrepo.findById(id);

	    if (existingData.isPresent()) {
	    	existingData.get().setIsActive(false);
	    	subCategoryrepo.save(existingData.get());
	        return new Response<>(HttpStatus.OK.value(), "Subject Category Deactivated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Subject Category  not found", null);
	    }
	}

}
