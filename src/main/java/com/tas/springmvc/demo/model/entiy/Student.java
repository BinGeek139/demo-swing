package com.tas.springmvc.demo.model.entiy;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	public Student(String fullName, Date dateOfBirth, String address, String school) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.school = school;
	}
	private int  id;
	private String fullName;
	private Date dateOfBirth;
	private String address;
	private String school;

}
