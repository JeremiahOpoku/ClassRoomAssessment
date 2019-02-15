package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {  

	@Inject
	private JSONUtil util;
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		em.persist(aClassroom);
		return "{\"message\": \"Classroom has been sucessfully added\"}";
	}

	public String getAllClassrooms() {
		Query query = em.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String updateClassroom(String classroom, Long classroomId) {
		deleteClassroom(classroomId);
		createClassroom(classroom);

		return "{\"message\": \"Classroom has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomId) {
		em.remove(em.find(Classroom.class, classroomId));
		return "{\"message\": \"Classroom has been sucessfully deleted\"}";
	}

	public void setManager(EntityManager em) {
		this.em = em;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
