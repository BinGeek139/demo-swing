package com.tas.springmvc.demo.model.entiy;

import java.sql.Date;
import java.util.StringTokenizer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWapper {
	private String fullName;
	private String  dateOfBirth;
	private String address;
	private String school;
	public Student toStudent() {
		
		return new Student(fullName, fomatDate(dateOfBirth), address, school);
	}
	private Date fomatDate(String s) {
		StringTokenizer tokenizer=new StringTokenizer(s,"/");
			 
			String ngay = (String) tokenizer.nextElement();
			String thang = (String) tokenizer.nextElement();
			String nam= (String) tokenizer.nextElement();
			Date date=new Date(Integer.valueOf(nam), Integer.valueOf(thang), Integer.valueOf(ngay));
			
			return date;
	}
	
}
