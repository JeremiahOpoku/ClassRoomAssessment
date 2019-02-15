package com.qa.business.repository;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService { 
	
	@Inject
	private ClassroomRepository repo;
	@Inject
	private JSONUtil util;
	
	

	public String getAllClassroom() {
		return repo.getAllClassrooms(); 

	}

	public String createClassroom(String classroom) {
	Classroom aClass = util.getObjectForJSON(classroom, Classroom.class);
			return repo.createClassroom(classroom);

	}

	public String deleteClassroom(Long classroomID) {
		repo.deleteClassroom(classroomID);
		return "{\"message\": \"Classroom has been succesfully deleted\"}";
	}

	public String updateClassroom(Long classroomID, String classroom) {
		repo.deleteClassroom(classroomID);
		repo.createClassroom(classroom);
		return "{\"message\": \"Account has been successfully updated\"}";
	}
	

}
