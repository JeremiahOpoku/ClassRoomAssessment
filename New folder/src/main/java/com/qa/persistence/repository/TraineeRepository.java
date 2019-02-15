package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String createTrainee(String traineeName);
	String getAllTrainees();
	String deleteTrainees(Long traineeID);
	String updateTrainee(Long traineeID, String traineeName);
}
