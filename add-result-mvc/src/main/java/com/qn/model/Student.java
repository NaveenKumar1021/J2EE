package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
	
	private int id ;
	private String name;
	private int marks1;
	private int marks2;
	private int marks3;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public Student(int id, String name, int marks1, int marks2, int marks3) {
		super();
		this.id = id;
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	public Student() {
		super();
	}
	

	
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks1=" + marks1 + ", marks2=" + marks2 + ", marks3="
				+ marks3 + "]";
	}
	
	public int addResult() {
		
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//		DriverManager.registerDriver(new com.cj.jdbc.Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/naveen","root","1021Password*#");
		
		String query ="insert into student values(?,?,?,?,?)";
		
		PreparedStatement psmt = con.prepareStatement(query);
		
		psmt.setInt(1, id);
		psmt.setString(2,name);
		psmt.setInt(3,marks1);
		psmt.setInt(4,marks2);
		psmt.setInt(5,marks3);
		   
		int rows = psmt.executeUpdate();	
		
		return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	return 0;
}
}
