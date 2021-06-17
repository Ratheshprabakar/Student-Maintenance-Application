/* @Class : StudentMaintanenceServiceImplementation
 * @Description : Class to perform all the Service methods to our REST API
 * @Methods : 
 * 		1. addStudent(StudentInfoBean studentInfoBean) - To Insert a Student Data
 * 		2. gradeCalculation(double aggregateMark) - To return the grade by calculating Aggregate marks
 * 		3. searchStudent(int id) - To Search a Student data
 * 		4. deleteStudent(int id) - To remove a student data
 * 		5. updateStudent(StudentInfoBean studentInfoBean) - To update student email
 * 		6. getGrade(int id) - To retrive Grade of the student
 * `	7. getMark(int id) - To retrive aggregate mark of the student 
 * */
package com.onebill.Spring.service;

/*
 * @author : Rathesh Prabakar
 * @Version 2.0 17/06/2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.Spring.DAO.StudentMaintenanceDAO;
import com.onebill.Spring.bean.StudentInfoBean;

@Service
public class StudentMaintanenceServiceImplementation implements StudentMaintenanceService {

	@Autowired
	StudentMaintenanceDAO dao;

	// To Insert a Student Data
	public boolean addStudent(StudentInfoBean studentInfoBean, double quaterlyMark, double halfYearlyMark,
			double AnnualMark) {
		double aggregateMark = ((quaterlyMark + halfYearlyMark + AnnualMark) / 3) / 10;
		studentInfoBean.setMarks(aggregateMark);
		studentInfoBean.setGrade(gradeCalculation(aggregateMark));
		return dao.addStudent(studentInfoBean);
	}

	// To return the grade by calculating Aggregate marks
	private String gradeCalculation(double aggregateMark) {
		if (aggregateMark >= 9.1 && aggregateMark <= 10.0)
			return "A+";
		else if (aggregateMark >= 8.1 && aggregateMark <= 9.0)
			return "A";
		else if (aggregateMark >= 7.1 && aggregateMark <= 8.0)
			return "B";
		else if (aggregateMark >= 6.1 && aggregateMark <= 7.0)
			return "C";
		else if (aggregateMark >= 5.1 && aggregateMark <= 6.0)
			return "D";
		else if (aggregateMark >= 4.1 && aggregateMark <= 5.0)
			return "E";
		else
			return "Fail";

	}

	// To Search a Student data
	@Override
	public StudentInfoBean searchStudent(int id) {
		// TODO Auto-generated method stub
		if (id < 0) {
			return null;
		}
		return dao.searchStudent(id);
	}

	// To remove a student data
	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		if (id < 0) {
			return false;
		}
		return dao.deleteStudent(id);
	}

	// To update student email
	@Override
	public boolean updateStudent(StudentInfoBean studentInfoBean) {
		// TODO Auto-generated method stub
		if (studentInfoBean != null) {
			return dao.updateStudent(studentInfoBean);
		}
		return false;
	}

	// To retrive Grade of the student
	@Override
	public StudentInfoBean getGrade(int id) {
		if (id < 0) {
			return null;
		}
		return dao.searchStudent(id);
	}

	// To retrive aggregate mark of the student
	@Override
	public StudentInfoBean getMark(int id) {
		if (id < 0) {
			return null;
		}
		return dao.searchStudent(id);
	}

}
