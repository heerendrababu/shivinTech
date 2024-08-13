package com.shivintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.shivintech.model.BookedDoctor;

public class BookedDoctorDataAccess 
{
	  private static String dbUrl="jdbc:mysql://localhost:3306/springmvc";
	  private static String dbUsername="babu";
	  private static String dbPassword="babu@123";
	  
	  private static Connection cn=null;
	  private static PreparedStatement ps=null;
	  private static Statement st = null;
	  
		// (2) write jdbc code for inserting doctor Data into DB
		 public static void BookedDoctorData(BookedDoctor bd)
		 {
			    try
			    {
					Class.forName("com.mysql.cj.jdbc.Driver");
					cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
					//step 3:prepared Statement
					ps = cn.prepareStatement("insert into BookedDoctor(did,name,profession,email,mob,appointmentDate) values(?,?,?,?,?,?)");
	// To get value present in bean class private variable we will use getter methods because we are using Doctor input type in method.
		           ps.setInt(1, bd.getDoctorId());	
		           ps.setString(2, bd.getDoctorName());
		           ps.setString(3, bd.getDoctorProfession());
		           ps.setString(4, bd.getDoctorEmail());
		           ps.setString(5, bd.getDoctorMobile());
                   ps.setString(6, bd.getAppointmentDate());		           
		           ps.executeUpdate();
		
				     
				} 
			    catch (ClassNotFoundException | SQLException e)
			    {
					e.printStackTrace();
				}
			    finally
			    {
			    	if(ps!=null) // To avoid null pointer Exception
					{
						try
						{
							ps.close();
						} 
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					if(cn!=null)
					{
						try
						{
							cn.close();
						}
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
					}
			    }
		   }
}
