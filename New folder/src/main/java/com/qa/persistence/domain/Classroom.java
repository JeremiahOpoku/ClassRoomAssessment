package com.qa.persistence.domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity
	public class Classroom {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(length = 6)
		private Long classroomId;
		
		@Column(length = 40)
		private String classroom;
		
		@Column(length = 40)
		private String trainer;
		
		@OneToMany (targetEntity = Trainee.class, mappedBy = "classoom")
		@Column(length = 100)
		public List<Trainee> trainees ;
		
		public Classroom() { 
		}
		
		public Classroom(String classroom, String trainer, List<Trainee> trainees) { 
			super();
			this.trainer = trainer;
			this.trainees = trainees;
		}
		public String getClassroom() {
			return classroom;
		}

		public String getTrainer() {
			return trainer;
		}

		public void setTrainer(String trainer) {
			this.trainer = trainer;
		}

		public Long getClassroomId() {
			return classroomId;
		}

		public void setClassroomId(Long classroomId) {
			this.classroomId = classroomId;
		}

		public void setTrainees(List<Trainee> trainees) {
			this.trainees = trainees;
		}
		
}
