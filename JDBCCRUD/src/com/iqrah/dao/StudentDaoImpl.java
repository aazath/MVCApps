package com.iqrah.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iqrah.dto.Student;
import com.iqrah.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao{

	Connection connection = null;
	String status;
	@Override
	public String save(Student student) {
		String InsertSqlQuery = "Insert into student_details (sname,sage,saddr) values(?,?,?)";
		PreparedStatement pstm = null;
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null)
				pstm = connection.prepareStatement(InsertSqlQuery);
			
			if(pstm!=null)
			{
				pstm.setString(1, student.getSname());
				pstm.setInt(2, student.getSage());
				pstm.setString(3, student.getSaddr());
				int rowsAffected = pstm.executeUpdate();
				
				if(rowsAffected == 1)
				{
					status = "success";
				}
				else
					status = "failure";
			}
			
		} catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		String selectSqlQuery = "select sname,sage,saddr from student_details where sid =?";
		PreparedStatement pstm = null;
		Student student = null;
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null)
				pstm = connection.prepareStatement(selectSqlQuery);
			
			if(pstm!=null)
			{
				pstm.setInt(1, sid);
				ResultSet rs = pstm.executeQuery();
				
				if(rs.next())
				{
					student = new Student();
					student.setSname(rs.getString(1));
					student.setSage(rs.getInt(2));
					student.setSaddr(rs.getString(3));
				}
				
			}
			
		} catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		return student;
		
	}

	@Override
	public String updateById(Student student) {
		String updateSqlQuery = "update student_details set sname =?,sage=?,saddr=? where sid =?";
		PreparedStatement pstm = null;
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null)
				pstm = connection.prepareStatement(updateSqlQuery);
			
			if(pstm!=null)
			{
				pstm.setString(1, student.getSname());
				pstm.setInt(2, student.getSage());
				pstm.setString(3, student.getSaddr());
				pstm.setInt(4, student.getSid());
				int rowsAffected = pstm.executeUpdate();
				
				if(rowsAffected == 1)
				{
					status = "success";
				}
				else
					status = "failure";
			}
			
		} catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		String deleteSqlQuery = "Delete from student_details where sid =?";
		PreparedStatement pstm = null;
		try {
			Student student = findById(sid);
			if(student!=null) {
				connection = JdbcUtil.getConnection();
				if(connection != null)
					pstm = connection.prepareStatement(deleteSqlQuery);				
					if(pstm!=null){
						pstm.setInt(1, sid);
						int rowsAffected = pstm.executeUpdate();
						
						if(rowsAffected == 1)
						{
							status = "success";
						}
					}
			}
			else {
				status = "Record not available";
			}
			
		} catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		return status;
	}

}
