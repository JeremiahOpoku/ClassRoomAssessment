package com.qa.business.repository;

public interface TraineeService {
	
	String getAllTrainees();
	String createTrainee(String traineeName);
	String deleteTrainee(Long traineeID);
	String updateTrainee(Long traineeID, String traineeName);

}
