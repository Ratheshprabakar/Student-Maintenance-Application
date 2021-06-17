package com.onebill.Spring.DAO;

import com.onebill.Spring.bean.StudentInfoBean;

public interface StudentMaintenanceDAO {
	
	public boolean addStudent(StudentInfoBean studentInfoBean);
	
	public StudentInfoBean searchStudent(int id);
	
	public boolean deleteStudent(int id);
	
	public boolean updateStudent(StudentInfoBean studentInfoBean);
	





	

}
