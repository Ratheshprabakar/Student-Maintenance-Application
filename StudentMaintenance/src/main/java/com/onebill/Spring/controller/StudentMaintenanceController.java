package com.onebill.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.Spring.bean.StudentInfoBean;
import com.onebill.Spring.response.StudentMaintenanceResponse;
import com.onebill.Spring.service.StudentMaintenanceService;

@RestController
public class StudentMaintenanceController {

	@Autowired
	StudentMaintenanceService service;

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentMaintenanceResponse insertStudent(@RequestBody StudentInfoBean studentInfoBean) {
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();

		if (service.addStudent(studentInfoBean)) {
			response.setStatusCode(200);
			response.setStatusMessage("Success");
			response.setDescription("Successfully Inserted");
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Data not get added");
		}
		return response;
	} // end of Insert Student data

	@GetMapping(path = "/search/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentMaintenanceResponse searchStudent(@PathVariable(name = "id") int id) {
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();
		StudentInfoBean studentInfoBean = service.searchStudent(id);

		if (studentInfoBean != null) {
			response.setStatusCode(200);
			response.setStatusMessage("Success");
			response.setDescription("Record Found for ID " + id);
			response.setStudentInfoBean(studentInfoBean);
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Record not found for ID " + id);
		}
		return response;
	} // end of Search a Student data

	@DeleteMapping(path = "/remove/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentMaintenanceResponse removeStudent(@PathVariable(name = "id") int id) {
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();

		if (service.deleteStudent(id)) {
			response.setStatusCode(200);
			response.setStatusMessage("Success");
			response.setDescription("Successfully Deleted record with ID " + id);
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Entry not found for ID " + id);
		}
		return response;
	} // end of Remove a Student

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentMaintenanceResponse updateStudentEmail(@RequestBody StudentInfoBean studentInfoBean) {
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();

		if (service.updateStudent(studentInfoBean)) {
			response.setStatusCode(200);
			response.setStatusMessage("Success");
			response.setDescription("Successfully Updated the email for ID " + studentInfoBean.getUserid());
			response.setStudentInfoBean(studentInfoBean);
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Data not found");
		}
		return response;
	} // End of Update Email Address for a student
	
	@GetMapping(path="/getGrade/{id}", produces= {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public StudentMaintenanceResponse getGrade(@PathVariable(name="id") int id) {
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();
		StudentInfoBean studentInfoBean = service.getGrade(id);
		if (studentInfoBean!=null) {
			response.setStatusCode(200);
			response.setStatusMessage("Success");
			response.setDescription("Grade for " + studentInfoBean.getName()+" is "+studentInfoBean.getGrade());
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Data not found with ID "+id);
		}
		return response;
	} // end of Retrive Grade of the Student
}
