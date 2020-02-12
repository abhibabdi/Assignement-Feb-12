package com.ibm.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	
	/*
	
	Connection dbCon;
	
    Employee()
    { 
    	try {
			DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?useTimezone=true&serverTimezone=UTC","root","");
		} catch (SQLException e) {
			System.out.println("Some error : "+e.getMessage());
			
		}
    	
    }*/
    

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    
			Connection dbCon;
		
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useTimezone=true&serverTimezone=UTC","root","");
			
		
		
		
		System.out.println("1. Enter Employee Details");
		System.out.println("2. Update Employee Details");
		System.out.println("3. Delete Employee Details By Employee Id");
		System.out.println("4. Display All Employee Details");
		
		
		
		boolean ex = true;
		while(ex)
			
		{
			System.out.println("Please Enter Your Choice : ");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter Employee Name : ");
				String name = scan.next();
				
				System.out.println("Enter Employee ID : ");
				int id = scan.nextInt();
				
				System.out.println("Enter Employee Age : ");
				int age = scan.nextInt();
				
				System.out.println("Enter Employee Gender : ");
				String gender = scan.next();
				
				System.out.println("Enter Employee Salary : ");
				int salary = scan.nextInt();
				
				
				
				String insertQ = "insert into emp_details values" + "(" +"'"+name+"'"+","+"'"+id+"'"+","+"'"+age+"'"+","+"'"+gender+"'"+","+"'"+salary+"'"+")";
				
				Statement stmt = dbCon.createStatement();
				
				if(stmt.executeUpdate(insertQ) > 0)
				{
					System.out.println("One Row Successfully Created!!!!!");
				}
				else
				{
					System.out.println("Some issues while inserting!!!!!!!");
				}
				
				
				
				
				
				break;
				
			case 2:
				
				System.out.println("Enter the Employee ID to update the Details");
				
				int id1 = scan.nextInt();
				
				System.out.println("What do you wanna Update 1. Name 2. Age 3. Salary");
				
				int ch = scan.nextInt();
				
				switch(ch)
				{
				case 1:
					
					System.out.println("Enter the new name : ");
					
					String newname = scan.next();
					
					String Que1 = "update emp_details set emp_Name="+"'"+newname+"'"+"WHERE emp_Id="+id1;
					
					//setInt(1,id1);
					
					Statement stmt2 = dbCon.createStatement();
					
					if(stmt2.executeUpdate(Que1) > 0)
					{
						System.out.println("One Row Has Been Updated Successfully!!!!!");
					}
					else
					{
						System.out.println("Some issues while Updating!!!!!!!");
					}
					
					
					
					break;
				case 2:
					
System.out.println("Enter the new age : ");
					
			int newage = scan.nextInt();
					String Que2 = "update emp_details set emp_Age="+"'"+newage+"'"+"WHERE emp_Id="+id1;
					
                   Statement stmt3 = dbCon.createStatement();
					
					if(stmt3.executeUpdate(Que2) > 0)
					{
						System.out.println("One Row Has Been Updated Successfully!!!!!");
					}
					else
					{
						System.out.println("Some issues while Updating!!!!!!!");
					}
					
                
					break;
				case 3:
					
System.out.println("Enter the new salary : ");
					
					String newsalary = scan.next();
					String Que3 = "update emp_details set emp_Salary="+"'"+newsalary+"'"+"WHERE emp_Id="+id1;
					
                    Statement stmt4 = dbCon.createStatement();
					
					if(stmt4.executeUpdate(Que3) > 0)
					{
						System.out.println("One Row Has Been Updated Successfully!!!!!");
					}
					else
					{
						System.out.println("Some issues while Updating!!!!!!!");
					}
					
					
					
					break;
					
					default :
						System.out.println("Invalid choice!!!!1");
						break;
					
				}
				
				break;
				
				
			case 3:
				System.out.println("Enter the Employee ID to delete its details : ");
				
				int id2 = scan.nextInt();
				
				String Que4 = "delete from emp_details where emp_Id="+id2;
				
				 Statement stmt5 = dbCon.createStatement();
					
					if(stmt5.executeUpdate(Que4) > 0)
					{
						System.out.println("One Row Has Been Deleted Successfully!!!!!");
					}
					else
					{
						System.out.println("Some issues while Deleting!!!!!!!");
					}
				
				
				
				break;
				
			case 4:
				
				
				System.out.println("Employee Details Are : ");
				//Connection dbCon =
				
				Statement stmt1 = dbCon.createStatement();
				
			//String fetchQry = "select * from other_details";
				
				String Que5 = "select * from emp_details";
				
				ResultSet rs = stmt1.executeQuery(Que5);
				
				while(rs.next())
				{
					System.out.print("Employee ID : "+rs.getInt("emp_Id")+"  , ");
					System.out.print(" Name : "+rs.getString("emp_Name")+"  , ");
					System.out.print(" Age : "+rs.getInt("emp_Age")+" , ");
					System.out.print(" Gender : "+rs.getString("emp_Gender")+" , ");
					System.out.println(" Salary : "+rs.getInt("emp_Salary"));
					
				}
				
				
		
				break;
				
				
	     default :
	    	 System.out.println("Invalid Choice");
				
				
				
				break;
				
				
				
			}
			System.out.println("Do you wanna continue : 1/2");
			
			int ch = scan.nextInt();
			
			if(ch == 1)
			{
				ex = true;
			}
			else
				ex = false;
		}
		dbCon.close();
		
		
		

	}
	 catch (SQLException e1) {
		
		 System.out.println("Some thing went wrong  : "+e1.getMessage());
	}
		catch(ClassNotFoundException e)
		{
			System.out.println("Some thing went wrong  : "+e.getMessage());
		}
	}


	private static void setInt(int i, int id) {
		// TODO Auto-generated method stub
		
	}


	private static void setString(int i, String name) {
		// TODO Auto-generated method stub
		
	}

}
