package com.qa.persistence.repository;


public interface ClassroomRepository {
	
	//Create
	String createClassroom (String classroom);
	
	//Read
	String getAllClassrooms();
	
	//Update
	String updateClassroom (String classroom, Long classroomId);
	
	//Delete
	String deleteClassroom (Long classroomId);
	

}
