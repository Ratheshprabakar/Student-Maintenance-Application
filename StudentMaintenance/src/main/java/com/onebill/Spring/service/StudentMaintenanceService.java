/* @Interface : StudentMaintenanceService
 * @Description : Interface to hold all the Service methods
 * @Methods : 
 * 		1. addStudent(StudentInfoBean studentInfoBean) - To Insert a Student Data
 * 		2. searchStudent(int id) - To Search a Student data
 * 		3. deleteStudent(int id) - To remove a student data
 * 		4. updateStudent(StudentInfoBean studentInfoBean) - To update student email
 * 		5. getGrade(int id) - To retrive Grade of the student
 * `	6. getMark(int id) - To retrive aggregate mark of the student 
 * */
package com.onebill.Spring.service;
/*
 * @author : Rathesh Prabakar
 * @Version 2.0 17/06/2021
 */

import com.onebill.Spring.bean.StudentInfoBean;

public interface StudentMaintenanceService {

	public boolean addStudent(StudentInfoBean studentInfoBean, double m1, double m2, double m3);

	public StudentInfoBean searchStudent(int id);

	public boolean deleteStudent(int id);

	public boolean updateStudent(StudentInfoBean studentInfoBean);

	public StudentInfoBean getGrade(int id);

	public StudentInfoBean getMark(int id);

}
