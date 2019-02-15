package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomDBRepositoryTest {  
	
	@InjectMocks
	private ClassroomDBRepository repo;

	@Mock
	private EntityManager em;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"classroomId\":1,\"trainer\":\"Jeremiah Opoku\",\"trainees\":[{\"traineeID\":1,\"traineeName\":\"Bert\"},{\"traineeID\":2,\"traineeName\":\"Jeff\"}]}]";

	private static final String MOCK_OBJECT = "{\"classroomId\":1,\"trainer\":\"Jeremiah Opoku\",\"trainees\":[{\"traineeID\":1,\"traineeName\":\"Bert\"},{\"traineeID\":2,\"traineeName\":\"Jeff\"}]}";

	@Before
	public void setup() {
		repo.setManager(em);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test

	public void testGetAllClassrooms() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);

		List<Classroom> classrooms = new ArrayList<Classroom>();

		List<Trainee> traineeList = new ArrayList<Trainee>();
		
		Trainee t1 = new Trainee();
		t1.setTraineeID(1L);
		t1.setTraineeName("Bert");
		Trainee t2 = new Trainee();
		t2.setTraineeID(2L);
		t2.setTraineeName("Jeff");
		
		traineeList.add(t1);
		traineeList.add(t2);
		
		Classroom aClass = new Classroom("Matt Hunt", "Jeremiah Opoku", traineeList);  
		
		aClass.setClassroomId(1L);
		
		classrooms.add(aClass);
		
		Mockito.when(query.getResultList()).thenReturn(classrooms);
		
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllClassrooms());
	}

	@Test
	public void testCreateClassroom() {
		String reply = repo.createClassroom(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Classroom has been sucessfully added\"}");
	}
	@Test
	public void testDeleteClassroom() {
		String reply = repo.deleteClassroom(1L);
		Assert.assertEquals(reply, "{\"message\": \"Classroom has been sucessfully deleted\"}");
	}
}
