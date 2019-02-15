package com.qa.business.repository;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService { 
	
	@Inject
	private TraineeRepository tra;
	@Inject 
	private JSONUtil util;

	public String getAllTrainees() {
		return tra.getAllTrainees();
	}

	public String createTrainee(String traineeName) {
		Trainee aTrainee = util.getObjectForJSON(traineeName, Trainee.class);
		return tra.createTrainee(traineeName);
	}

	public String deleteTrainee(Long traineeID) {
		tra.deleteTrainees(traineeID);
		return "{\"message\": \"Trainee has been succesfully deleted\"}";
	}

	public String updateTrainee(Long traineeID, String traineeName) {
		tra.deleteTrainees(traineeID);
		tra.createTrainee(traineeName);
		return "{\"message\": \"Account has been successfully updated\"}";
	}
	

}
