package com.sparrow.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicBatchYearEntity;
import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.AdminstratorEntity;
import com.sparrow.entity.CourseLevelEntity;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.InstituteTypeEntity;
import com.sparrow.entity.ProgramEntity;
import com.sparrow.entity.SectionEntity;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.entity.SubjectGroupEntity;
import com.sparrow.entity.SubjectMaster;
import com.sparrow.repo.AcademicBatchYearRepo;
import com.sparrow.repo.AcademicCourseRepo;
import com.sparrow.repo.AcademicSubjectRepo;
import com.sparrow.repo.AcademicYearRepo;
import com.sparrow.repo.AdminStratorRepo;
import com.sparrow.repo.CourseLevelRepo;
import com.sparrow.repo.DepartmentRepo;
import com.sparrow.repo.InstituteRepo;
import com.sparrow.repo.InstituteTypeRepo;
import com.sparrow.repo.ProgramRepo;
import com.sparrow.repo.SectionRepo;
import com.sparrow.repo.SubjectCategoryRepo;
import com.sparrow.repo.SubjectGroupRepo;
import com.sparrow.repo.SubjectMasterRepo;
import com.sparrow.repo.SubjectTypeRepo;





@Service
public class MasterService {
	@Autowired
	private InstituteRepo instRepo;
	@Autowired
	private InstituteTypeRepo instTypeRepo;
	@Autowired
	private AcademicYearRepo acdmRepo;
	@Autowired
	private AcademicBatchYearRepo acdmBatchRepo;
	@Autowired
	private AcademicCourseRepo acdmCourseRepo;
	@Autowired
	private SectionRepo secRepo;
	@Autowired
	private ProgramRepo programRepo;
	@Autowired
	private DepartmentRepo deptRepo;
	@Autowired
	private CourseLevelRepo courseLevelRepo;
	@Autowired
	private AcademicSubjectRepo acdmSubRepo;
	@Autowired
	private SubjectTypeRepo subTypeRepo;
	@Autowired
	private SubjectGroupRepo subGrpRepo;
	@Autowired
	private SubjectCategoryRepo subCategoryRepo;
	@Autowired
	private SubjectMasterRepo subRepo;
	@Autowired
	private AdminStratorRepo adminstratorRepo;
	

	

	
	public Response<?> addInstitute(InstituteEntity instEntity) {
		
		InstituteEntity inst =instRepo.save(instEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Institute Created Successfully!!", inst);
	}
	
	public List<InstituteEntity> getAllInstitute(){
		return instRepo.getAllActivelist();
		
	}
	public Optional<?> getInstituteById(long id) {
		return instRepo.findById(id);
	}
	
	public InstituteEntity updateInstitute(InstituteEntity instEntity) {
		Optional<InstituteEntity> optional=instRepo.findById(instEntity.getInstituteId());
		InstituteEntity existingInstEntity=optional.get();
		
			existingInstEntity.setAffiliateOrg(instEntity.getAffiliateOrg());
			existingInstEntity.setAffiliationNo(instEntity.getAffiliationNo());
			existingInstEntity.setEmail(instEntity.getEmail());
			existingInstEntity.setFkInstituteTypeId(instEntity.getFkInstituteTypeId());
			existingInstEntity.setInstAddrs(instEntity.getInstAddrs());
			existingInstEntity.setInstAffilioationDt(instEntity.getInstAffilioationDt());
			existingInstEntity.setInstituteIdPrefix(instEntity.getInstituteIdPrefix());
			existingInstEntity.setInstituteName(instEntity.getInstituteName());
			existingInstEntity.setInstLogo(instEntity.getInstLogo());
			existingInstEntity.setIsActive(true);
			existingInstEntity.setPhNo(instEntity.getPhNo());
			InstituteEntity updatedInstData=instRepo.save(existingInstEntity);
			return updatedInstData;
			
		}
	
	public List<InstituteTypeEntity> getAllInstituteType(){
		return instTypeRepo.getAllActivelist();
		
	}
    public Response<?> addAcademicYear(AcademicYearEntity acdmYearEntity) {
		
	      AcademicYearEntity academicYearData =acdmRepo.save(acdmYearEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Academic Year Added Successfully!!", academicYearData);
	}
    public List<AcademicYearEntity> getAllAcademicYear(Long instituteId){
		return acdmRepo.getAllActivelist(instituteId);
		
	}
    public AcademicYearEntity getAcademicYearById(Long instituteId,Long academicYearId) {
		return acdmRepo.getAcademicYearById(instituteId, academicYearId);
	
	
    }
    public AcademicYearEntity updateAcademicYear(AcademicYearEntity acdmYearEntity) {
		Optional<AcademicYearEntity> optional=acdmRepo.findById(acdmYearEntity.getAcademicSetupId());
		AcademicYearEntity existingAcdmYearEntity=optional.get();
		existingAcdmYearEntity.setAcademicYear(acdmYearEntity.getAcademicYear());
		existingAcdmYearEntity.setEndDate(acdmYearEntity.getEndDate());
		existingAcdmYearEntity.setFkBatchYearId(acdmYearEntity.getFkBatchYearId());
		existingAcdmYearEntity.setFkInstituteId(acdmYearEntity.getFkInstituteId());
		existingAcdmYearEntity.setStartDate(acdmYearEntity.getStartDate());
		existingAcdmYearEntity.setIsActive(true);
		AcademicYearEntity updatedAcademicYearData=acdmRepo.save(existingAcdmYearEntity);
		
		return updatedAcademicYearData;

}
    public List<AcademicBatchYearEntity> getAllAcademicBatchYear(){
		return acdmBatchRepo.getAllActivelist();
		
	}
    public Response<?> addAcademicCourse(AcademicCourseEntity acdmCourseEntity) {
    	String courseTittle=courseLevelRepo.findCourseLevelNameById(acdmCourseEntity.getFkCourseLevelId().getCourseLevelId())
    			+"-"+programRepo.findProgramNameById(acdmCourseEntity.getFkProgramId().getProgramId())
    			+"-"+deptRepo.findDepartmentNameById(acdmCourseEntity.getFkDeptId().getDepartmentId())
    			+"-"+secRepo.findSectionNameById(acdmCourseEntity.getFkSectionId().getSectionId());
    	acdmCourseEntity.setCourseTitle(courseTittle);
    	//String secName=secRepo.findSectionNameById(acdmCourseEntity.getFkDeptId().getDepartmentId());
    	acdmCourseEntity.setSectionStudents(secRepo.findNoStudentsBySection(acdmCourseEntity.getFkSectionId().getSectionId(),
    			acdmCourseEntity.getFkDeptId().getDepartmentId()));
	    AcademicCourseEntity acdmCourseData =acdmCourseRepo.save(acdmCourseEntity);
	    return new Response<>(HttpStatus.CREATED.value(), "Academic Course Created Successfully!!", acdmCourseData);
	}
    public AcademicCourseEntity updateAcademicCourse(AcademicCourseEntity acdmCourseEntity) {
    	AcademicCourseEntity existingAcdmCourseEntity=acdmCourseRepo.findById(acdmCourseEntity.getAcademicCouirseId()).get();
    	String courseTittle=courseLevelRepo.findCourseLevelNameById(acdmCourseEntity.getFkCourseLevelId().getCourseLevelId())
    			+"-"+programRepo.findProgramNameById(acdmCourseEntity.getFkProgramId().getProgramId())
    			+"-"+deptRepo.findDepartmentNameById(acdmCourseEntity.getFkDeptId().getDepartmentId())
    			+"-"+secRepo.findSectionNameById(acdmCourseEntity.getFkSectionId().getSectionId());
    	existingAcdmCourseEntity.setSectionStudents(secRepo.findNoStudentsBySection(acdmCourseEntity.getFkSectionId().getSectionId(),
    			acdmCourseEntity.getFkDeptId().getDepartmentId()));
    	existingAcdmCourseEntity.setCourseDuration(acdmCourseEntity.getCourseDuration());
    	existingAcdmCourseEntity.setCourseTitle(courseTittle);
    	existingAcdmCourseEntity.setCourseSemester(acdmCourseEntity.getCourseSemester());
    	existingAcdmCourseEntity.setEvenSemesterStDt(acdmCourseEntity.getEvenSemesterStDt());
    	existingAcdmCourseEntity.setOddSemesterStDt(acdmCourseEntity.getOddSemesterStDt());
    	existingAcdmCourseEntity.setFkCourseLevelId(acdmCourseEntity.getFkCourseLevelId());
    	existingAcdmCourseEntity.setFkDeptId(acdmCourseEntity.getFkDeptId());
    	existingAcdmCourseEntity.setFkInstituteId(acdmCourseEntity.getFkInstituteId());
    	existingAcdmCourseEntity.setFkProgramId(acdmCourseEntity.getFkProgramId());
    	existingAcdmCourseEntity.setFkSectionId(acdmCourseEntity.getFkSectionId());
    	AcademicCourseEntity updatedAcademicCourseData=acdmCourseRepo.save(existingAcdmCourseEntity);
		
		return updatedAcademicCourseData;

}

    public List<AcademicCourseEntity> getAllAcademicCourse(Long instituteId){
	    return acdmCourseRepo.getAllActivelist(instituteId);
	
}
    public AcademicCourseEntity getAcademicCourseById(long instituteId ,Long academicCourseId) {
		return acdmCourseRepo.getAcademicCourseById(instituteId, academicCourseId);
	}
    public List<SectionEntity> getAllSectionByDepartment(Long departmentId){
		return secRepo.findAllSectionByDepartmentId(departmentId);
		
	}
    public List<ProgramEntity> getAllProgramByLevelId(Long levelId){
		return programRepo.findAllProgramByLevelId(levelId);
}
    public List<DepartmentEntity> getAllDepartmentByProgramId(Long programId){
		return deptRepo.findAllDepartmentByProgramId(programId);
}
    public List<CourseLevelEntity> getAllCourseLevel(){
		return courseLevelRepo.getAllActivelist();
}
/*
 * public Response<?> updateAcademicCourse(AcademicCourseEntity
 * acdmCourseEntity) { Optional<AcademicCourseEntity>
 * optional=acdmCourseRepo.findById(acdmCourseEntity.getAcademicCouirseId());
 * 
 * if(optional.isPresent()) { acdmCourseEntity.setIsActive(true);
 * AcademicCourseEntity AcdmCourseEntity=acdmCourseRepo.save(acdmCourseEntity);
 * return new
 * Response<>(HttpStatus.FOUND.value(),"AcademicCourse Updated Sucessfully"
 * ,AcdmCourseEntity);
 * 
 * } else { return new Response<>(HttpStatus.NOT_FOUND.value()
 * ,"AcademicCourse With provided data not found"); }
 * 
 * }
 */
   
    
    public Response<?> addAcademicSubject(AcademicSubjectEntity acdmSubjectEntity) {
		
    	AcademicSubjectEntity academicSubjectData =acdmSubRepo.save(acdmSubjectEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Subject Added Successfully!!", academicSubjectData);
	}
    public List<AcademicSubjectEntity> getAllAcademicSubjects(Long instituteId){
		return acdmSubRepo.getAllActivelist(instituteId);
		
	}
    public AcademicSubjectEntity getAcademicSubjectById(Long instituteId,Long academicSubId) {
		return acdmSubRepo.getAcademicSubById(instituteId, academicSubId);
    }
    public AcademicSubjectEntity updateAcademicSubject(AcademicSubjectEntity acdmSubjectEntity) {
    	AcademicSubjectEntity existingAcdmSubjectEntity=acdmSubRepo.findById(acdmSubjectEntity.getAcdmSubId()).get();
    	existingAcdmSubjectEntity.setAcdmSubCode(acdmSubjectEntity.getAcdmSubCode());
    	existingAcdmSubjectEntity.setAcdmSubTitle(acdmSubjectEntity.getAcdmSubTitle());
    	existingAcdmSubjectEntity.setFkInstituteId(acdmSubjectEntity.getFkInstituteId());
    	existingAcdmSubjectEntity.setFkSubTypeId(acdmSubjectEntity.getFkSubTypeId());
    	existingAcdmSubjectEntity.setIsActive(true);
    	AcademicSubjectEntity updatedAcademicSubkjectData=acdmSubRepo.saveAndFlush(existingAcdmSubjectEntity);
    	
		return updatedAcademicSubkjectData;

}
public Response<?> addSubjectGroup(SubjectGroupEntity subjectGroupEntity) {
		
	SubjectGroupEntity subjectGroupEntityData =subGrpRepo.save(subjectGroupEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Subject Group Added Successfully!!", subjectGroupEntityData);
	}

public List<SubjectGroupEntity> getAllSubjectGroup(Long instituteId){
		return subGrpRepo.getAllActivelist(instituteId);
}
public Response<?> addSubjectCategory(SubjectCategoryEntity subjectCategoryEntity) {
	
	SubjectCategoryEntity subjectCategoryEntityData =subCategoryRepo.save(subjectCategoryEntity);
		return new Response<>(HttpStatus.CREATED.value(), "Subject  Added Successfully!!", subjectCategoryEntityData);
	}
public List<SubjectCategoryEntity> getAllSubjectCategory(Long instituteId){
	return subCategoryRepo.getAllActivelist(instituteId);
}
public List<SubjectMaster> addUnits(List<SubjectMaster> subs) {
	subs.forEach(sub -> sub.setIsActive(true));
	Iterable<SubjectMaster> savedEntities = subRepo.saveAll(subs);
	List<SubjectMaster> savedEntityList = StreamSupport.stream(savedEntities.spliterator(), false)
			.collect(Collectors.toList());
	return savedEntityList;
}
public Response<?> addAcademicSubject(AdminstratorEntity adminstratorEntity) {
	
	AdminstratorEntity adminstratorSubjectData =adminstratorRepo.save(adminstratorEntity);
	return new Response<>(HttpStatus.CREATED.value(), "Subject Added Successfully!!", adminstratorSubjectData);
}

}

