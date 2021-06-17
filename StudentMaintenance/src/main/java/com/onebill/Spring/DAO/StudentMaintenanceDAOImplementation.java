package com.onebill.Spring.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.onebill.Spring.bean.StudentInfoBean;

@Repository
public class StudentMaintenanceDAOImplementation implements StudentMaintenanceDAO {

	@PersistenceUnit
	EntityManagerFactory factory;
	
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

	@Override
	public StudentInfoBean getGrade(int id) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		try {
			StudentInfoBean studentInfoBean = manager.find(StudentInfoBean.class, id);
			return studentInfoBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
