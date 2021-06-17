/*
 * @Class : StudentMaintenanceController
 * @Description : Rest Controller class to control all REST API's 
 * @API's 
 * 		1. To Insert a Student Data(path variables = quaterlyMark/halfYearlyMark/AnnualMark) -  /add/{quaterlyMark}/{halfYearlyMark}/{AnnualMark} 
 * 		2. To Search a Student Data(path variable = id) - /search/{id}
 * 		3. To Remove a Student Data(path variable = id) - /remove/{id}
 * 		4. To Update student Email Address(request body = StudentInfoBean object contains id and email only) - /update
 * 		5. To return Aggregate Marks(path variable = id) - /getMark/{id}
 * 		6. To retrive Grade of the student(path variable = id) - /getGrade/{id}
 * */
package com.onebill.Spring.controller;

/* @author : Rathesh Prabakar
 * @version : 2.0 17/06/2021
 * */

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

	@PostMapping(path = "/add/{quaterlyMark}/{halfYearlyMark}/{AnnualMark}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentMaintenanceResponse insertStudent(@PathVariable(name="quaterlyMark") double quaterlyMark, 
			@PathVariable(name="halfYearlyMark") double halfYearlyMark, 
			@PathVariable(name="AnnualMark") double AnnualMark,
			@RequestBody StudentInfoBean studentInfoBean) {
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();

		if (service.addStudent(studentInfoBean,quaterlyMark,halfYearlyMark,AnnualMark)) {
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
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Data not found");
		}
		return response;
	} // End of Update Email Address for a student
	
	@GetMapping(path="/getMark/{id}", produces= {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public StudentMaintenanceResponse getAggregateMarks(@PathVariable(name="id") int id) {
		
		StudentMaintenanceResponse response = new StudentMaintenanceResponse();
		StudentInfoBean studentInfoBean = service.getMark(id);
		if (studentInfoBean!=null) {
			response.setStatusCode(200);
			response.setStatusMessage("Success");
			response.setDescription("Aggregate Mark for " + studentInfoBean.getName()+" is "+studentInfoBean.getMarks());
		} else {
			response.setStatusCode(404);
			response.setStatusMessage("Failure");
			response.setDescription("Data not found with ID "+id);
		}
		return response;		
	}
	
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
