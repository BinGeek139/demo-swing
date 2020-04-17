package com.tas.springmvc.demo.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.tas.springmvc.demo.model.dao.AbtractDemoMVCDao;
import com.tas.springmvc.demo.model.entiy.Student;


public class StudentDao  extends AbtractDemoMVCDao<Student>{
	
	@Override
	public Boolean add(final Student t)  {
		  String query="insert into SinhVien(fullName,dateOfBirth,address,school) values(?,?,?,?);";  
		  try {
			  Boolean check= jdbcTemplatel.execute(query, new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
						ps.setString(1, t.getFullName());
						ps.setDate(2,t.getDateOfBirth());
						ps.setString(3,t.getAddress());
						ps.setString(4,t.getSchool());
						
						return ps.execute();
					}
				});
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	@Override
	public Boolean addMany(List<Student> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(final Student t) {
		String query="update SinhVien set fullname=? ,dateOfBirth=? , address =?,school=? where id=?";
		return jdbcTemplatel.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, t.getFullName());
				ps.setDate(2,t.getDateOfBirth());
				ps.setString(3, t.getAddress());
				ps.setString(4, t.getSchool());
				ps.setInt(5, t.getId());
			}
		});

	}

	@Override
	public int updateMany(List<Student> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(final int id) {
		String query="delete from SinhVien where id ="+id;
		return jdbcTemplatel.update(query);
	}

	@Override
	public int deleteManyById(List<Integer> list) {
		StringBuilder builder=new StringBuilder("delete from SinhVien where ");
	for (int i=0;i< list.size();i++) {
		if(i==0) {
			builder.append("id ="+list.get(i) );
			
		} else {
			builder.append(" or id ="+list.get(i) );
		}
		
		
	}
	System.out.println(builder.toString());
	
		return  jdbcTemplatel.update(builder.toString());
	}

	@Override
	public Student searchById(int id) {
//		String query="select * from SinhVien where id=?";
//		List<Student> list= jdbcTemplatel.query(query,new  RowMapper)
		return null;
	}

	@Override
	public List<Student> getAll() {
		  String query="select * from SinhVien;";  
		  return jdbcTemplatel.query(query,new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student=new Student();
						student.setId(rs.getInt(1));
						student.setFullName(rs.getString(2));
						student.setDateOfBirth(rs.getDate(3));
						student.setAddress(rs.getString(4));
						student.setSchool(rs.getString(5));
				return student ;
			}
		});
	}

}
