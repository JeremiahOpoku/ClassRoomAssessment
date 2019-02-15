package com.qa.persistence.domain;
	import java.lang.reflect.Array;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Trainee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(length = 10)
		private Long traineeID;
		@Column(length = 100)
		private String traineeName;
		
		public Long getTraineeID() {
			return traineeID;
		}
		public void setTraineeID(Long traineeID) {
			this.traineeID = traineeID;
		}
		public String getTraineeName() {
			return traineeName;
		}
		public void setTraineeName(String traineeName) {
			this.traineeName = traineeName;
		}
	}
		
		
		


		
		