/* @Class : StudentMaintenanceDAOImplementation
 * @Description : Implementation class for all the DAO methods
 * @PersistenceUnit : factory
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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.onebill.Spring.bean.StudentInfoBean;

@Repository
public class StudentMaintenanceDAOImplementation implements StudentMaintenanceDAO {

	@PersistenceUnit
	EntityManagerFactory factory;
	
	//To Insert a Student Data
	public boolean addStudent(StudentInfoBean studentInfoBean) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(studentInfoBean);
			transaction.commit();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	//To Search a Student data
	@Override
	public StudentInfoBean searchStudent(int id) {
		EntityManager manager = factory.createEntityManager();
		
		try {
			StudentInfoBean studentInfoBean = manager.find(StudentInfoBean.class, id);
			return studentInfoBean;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	//To remove a student data
	@Override
	public boolean deleteStudent(int id) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			StudentInfoBean studentInfoBean = manager.find(StudentInfoBean.class, id);
			transaction.begin();
			manager.remove(studentInfoBean);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	//To update student email
	@Override
	public boolean updateStudent(StudentInfoBean studentInfoBean) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			StudentInfoBean originalBean = manager.find(StudentInfoBean.class, studentInfoBean.getUserid());
			if(studentInfoBean.getEmail()!=null && studentInfoBean.getEmail()!="" ) {
				originalBean.setEmail(studentInfoBean.getEmail());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
