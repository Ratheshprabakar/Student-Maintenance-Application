package com.onebill.Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.Spring.DAO.StudentMaintenanceDAO;
import com.onebill.Spring.bean.StudentInfoBean;

@Service
public class StudentMaintanenceServiceImplementation implements StudentMaintenanceService {

	@Autowired
	StudentMaintenanceDAO dao;
	
	public boolean addStudent(StudentInfoBean studentInfoBean) {
		
		return dao.addStudent(studentInfoBean);		
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
		return dao.getGrade(id);
	}

}
