package com.StudentManagementProjectJDBC.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

	
	public static boolean insertStudent(Student st)
	{
		
		boolean flag = false;
		
		try {
			
			// jdbc connection
			Connection con = ConnectionProvider.createConnection();
			
			// Query 
			String query = "insert into students(sname,sphone,scity) values (?,?,?)";
			
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			// Set value of parameters
			pstmt.setString(1,st.getSname());
			pstmt.setString(2,st.getSphone());
			pstmt.setString(3,st.getScity());
			
			
			pstmt.executeUpdate();  // When query is not returning anydata
			
			flag=true;
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
				
	}

	
	public static boolean deleteStudent(int sid) {
		
		
		boolean flag = false;
		
		try {
			
			
			// JDBC CODE
			Connection con = ConnectionProvider.createConnection();
			String query = "delete from students where sid=?";
			
			
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			// Set Values
			pstmt.setInt(1,sid);

			pstmt.executeUpdate();  // When query is not returning anydata
			
			flag=true;
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}


	public static void DisplayStudent() {
	
		
		try {
			
			
			// JDBC CODE
			Connection con = ConnectionProvider.createConnection();
			String query = "select * from students";
			
			
			// Static Statement
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone =set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);
				
				System.out.println("-------------------------------------------");
				
			}
			
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}


	public static boolean UpdateStudent(Student st, int sid) {
		
		boolean flag = false;
		
		try {
			
			
			// JDBC CODE
			Connection con = ConnectionProvider.createConnection();
			String query = "update students set sid= ?, sname = ?, sphone= ?, scity=? where sid = ?";
			
			
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			// Set Values
			pstmt.setInt(1,st.getSid());
			pstmt.setString(2,st.getSname());
			pstmt.setString(3,st.getSphone());
			pstmt.setString(4,st.getScity());
			pstmt.setInt(5,sid);

			pstmt.executeUpdate();  // When query is not returning anydata
			
			flag=true;
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
		
		
		
	}
	
	
}
