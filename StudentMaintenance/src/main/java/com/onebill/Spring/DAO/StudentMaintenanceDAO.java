/* @Interface : StudentMaintenanceDAO
 * @Description : Interface to hold all the DAO methods
 * @Methods : 
 * 		1. addStudent(StudentInfoBean studentInfoBean) - To Insert a Student Data
 * 		2. searchStudent(int id) - To Search a Student data
 * 		3. deleteStudent(int id) - To remove a student data
 * 		4. updateStudent(StudentInfoBean studentInfoBean) - To update student email
 * */
package com.onebill.Spring.DAO;

/* @author : Rathesh Prabakar
 * @version : 2.0 17/06/2021
 * */

import com.onebill.Spring.bean.StudentInfoBean;

public interface StudentMaintenanceDAO {

	public boolean addStudent(StudentInfoBean studentInfoBean); // To Insert a Student Data

	public StudentInfoBean searchStudent(int id); //To Search a Student data

	public boolean deleteStudent(int id); //To remove a student data

	public boolean updateStudent(StudentInfoBean studentInfoBean); //To update student email

}
