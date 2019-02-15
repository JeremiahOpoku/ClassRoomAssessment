package com.qa.business.repository;

public interface ClassroomService {

	String getAllClassroom();
	String createClassroom(String classroom);
	String deleteClassroom(Long classroomID);
	String updateClassroom(Long classroomID, String classroom);
}
