package com.onebill.Spring.service;

import com.onebill.Spring.bean.StudentInfoBean;

public interface StudentMaintenanceService {
	
	public boolean addStudent(StudentInfoBean studentInfoBean,double m1,double m2,double m3);
	
	public StudentInfoBean searchStudent(int id);
	
	public boolean deleteStudent(int id);
	
	public boolean updateStudent(StudentInfoBean studentInfoBean);
	
	public StudentInfoBean getGrade(int id);
	
	public StudentInfoBean getMark(int id);



}
