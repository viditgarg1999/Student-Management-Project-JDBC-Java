package com.StudentManagementProjectJDBC.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Hello User! Welcome to the System -");
		
		//Scanner sc=new Scanner(System.in);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

		
		while(true)
		{
			
			System.out.println("Menu:");
			System.out.println("Press 1 to ADD a Student");
			System.out.println("Press 2 to Delete a Student");
			System.out.println("Press 3 to Display Student details");
			System.out.println("Press 4 to Update Student details");
			System.out.println("Press 5 to Exit");
			System.out.println("Enter your Choice:");
			
			int ch =Integer.parseInt(in.readLine());
			
			if(ch==1)
			{
				// Add 
				
				//String sname,scity,sphone;
				
				System.out.println("Enter Name:");
				String sname=in.readLine();
				 
				System.out.println("Enter Phone Number:");
				String sphone=in.readLine();
				
				System.out.println("Enter City:");
				String scity=in.readLine();
				
				
				//sc.nextLine(); 
				
				Student st = new Student(sname,sphone,scity);
				
				
				if(StudentDAO.insertStudent(st))
				{
					System.out.println("Student Added Successfully");
				}
				else
				{
					System.out.println("Something Went Wrong :(");
				}
				
				
			}
			else if(ch==2)
			{
				// Delete
				
				System.out.println("Enter Student Id to delete:");
				int sid = Integer.parseInt(in.readLine());
				
				if(StudentDAO.deleteStudent(sid))
				{
					System.out.println("Student Deleted Successfully");
				}
				else
				{
					System.out.println("Something Went Wrong :(");
				}
				
			}
			else if(ch==3)
			{
				// Display
				
				StudentDAO.DisplayStudent();
				
			}
			else if(ch==4)
			{
				// Update
				
				System.out.println("Enter Student Id to Update:");
				int sid = Integer.parseInt(in.readLine());
				
				System.out.println("Enter Updated Sid:");
				int sid_new = Integer.parseInt(in.readLine());
				
				System.out.println("Enter Name:");
				String sname=in.readLine();
				 
				System.out.println("Enter Phone Number:");
				String sphone=in.readLine();
				
				System.out.println("Enter City:");
				String scity=in.readLine();
				
				
				//sc.nextLine(); 
				
				Student st = new Student(sid_new,sname,sphone,scity);
				
				
				if(StudentDAO.UpdateStudent(st, sid))
				{
					System.out.println("Details Updatd Successfully");
				}
				else
				{
					System.out.println("Something Went Wrong :(");
				}
				
			}
			else if(ch==5)
			{
				break;
			}
			else
			{
				System.out.println("Invalid Choice");
			}
						
		}
		
		System.out.println("Thanks for using the System! Good Bye:)");
		

	}

}
