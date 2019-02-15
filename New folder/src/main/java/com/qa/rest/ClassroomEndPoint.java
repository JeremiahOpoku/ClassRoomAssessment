package com.qa.rest;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.repository.ClassroomService; 

@Path("/classroom")
public class ClassroomEndPoint {
	@Inject
	ClassroomService svc;
	
	@Path("getAllClassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms() {
		return svc.getAllClassroom();
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({"application/json"})
	public String createClassroom(@PathParam("classroom") String classroom) {
		return svc.createClassroom(classroom);
	}
	
	@Path("deleteClassroom/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClassroom(@PathParam("classroomID") Long classroomID) {
		return svc.deleteClassroom(classroomID);
	}
	
	@Path("updateClassroom")
	@PUT
	@Produces({"application/json"})
	public String updateClassroom(@PathParam("classroomID") Long classroomID, String classroom) {
		return svc.updateClassroom(classroomID, classroom);
	}

	public void setService(ClassroomService svc) {
		this.svc = svc;
	}

}
