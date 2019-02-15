package com.qa.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.repository.ClassroomService;
import com.qa.rest.ClassroomEndPoint;


@RunWith(MockitoJUnitRunner.class)
public class ClassroomEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	
	@InjectMocks
	private ClassroomEndPoint ep;
	
	@Mock
	private ClassroomService svc;
	
	@Before
	public void setup() {
		ep.setService(svc);  
	}
		
		@Test
		public void testGetAllClassrooms() {
			Mockito.when(svc.getAllClassroom()).thenReturn(MOCK_VALUE);  
			Assert.assertEquals(MOCK_VALUE, ep.getAllClassrooms());	
		}
		
		@Test
		public void testCreateClassrooms() {
			Mockito.when(svc.createClassroom(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
			Assert.assertEquals(MOCK_VALUE, ep.createClassroom(MOCK_VALUE2));
			Mockito.verify(svc).createClassroom(MOCK_VALUE2);
		}
		
		@Test
		public void testDeleteClassroom() {
			Mockito.when(svc.deleteClassroom(1L)).thenReturn(MOCK_VALUE);
			Assert.assertEquals(MOCK_VALUE, ep.deleteClassroom(1L));
			Mockito.verify(svc).deleteClassroom(1L);
		}
}

