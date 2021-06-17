package com.onebill.Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.Spring.DAO.StudentMaintenanceDAO;
import com.onebill.Spring.bean.StudentInfoBean;

@Service
public class StudentMaintanenceServiceImplementation implements StudentMaintenanceService {

	@Autowired
	StudentMaintenanceDAO dao;
	
	public boolean addStudent(StudentInfoBean studentInfoBean,double quaterlyMark,double halfYearlyMark,double AnnualMark) {
		double aggregateMark = ((quaterlyMark + halfYearlyMark+ AnnualMark)/3)/10;
		studentInfoBean.setMarks(aggregateMark);
		studentInfoBean.setGrade(gradeCalculation(aggregateMark));
		return dao.addStudent(studentInfoBean);		
	}
	
	public String gradeCalculation(double aggregateMark) {
		if(aggregateMark>=9.1 && aggregateMark<=10.0)
			return "A+";
		else if(aggregateMark>=8.1 && aggregateMark<=9.0)
			return "A";
		else if(aggregateMark>=7.1 && aggregateMark<=8.0)
			return "B";
		else if(aggregateMark>=6.1 && aggregateMark<=7.0)
			return "C";
		else if(aggregateMark>=5.1 && aggregateMark<=6.0)
			return "D";
		else if(aggregateMark>=4.1 && aggregateMark<=5.0)
			return "E";
		else
			return "Fail";
			
	}

	@Override
	public StudentInfoBean searchStudent(int id) {
		// TODO Auto-generated method stub
		if(id<0) {
			return null;
		}
		return dao.searchStudent(id);
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		if(id<0) {
			return false;
		}
		return dao.deleteStudent(id);
	}

	@Override
	public boolean updateStudent(StudentInfoBean studentInfoBean) {
		// TODO Auto-generated method stub
		if(studentInfoBean!=null) {
			return dao.updateStudent(studentInfoBean);
		}
		return false;
	}

	@Override
	public StudentInfoBean getGrade(int id) {
		if(id<0) {
			return null;
		}
		return dao.searchStudent(id);
	}

	@Override
	public StudentInfoBean getMark(int id) {
		if(id<0) {
			return null;
		}
		return dao.searchStudent(id);		
	}

}
