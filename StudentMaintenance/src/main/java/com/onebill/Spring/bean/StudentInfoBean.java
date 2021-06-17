package com.onebill.Spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_info")
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
