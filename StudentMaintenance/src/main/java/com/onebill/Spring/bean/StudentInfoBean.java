/* @Beanclass : StudentInfoBean
 * @Description : Bean class to map database fields including userid, name, email, 
 *                aggregate mark, grade
 * */

package com.onebill.Spring.bean;

/*
 * @author : Rathesh Prabakar
 * @Version 2.0 17/06/2021
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_info")
public class StudentInfoBean {

	@Id
	private int userid;

	@Column
	private String email;

	@Column
	private double marks;

	@Column
	private String name;

	@Column
	private String grade;

}
