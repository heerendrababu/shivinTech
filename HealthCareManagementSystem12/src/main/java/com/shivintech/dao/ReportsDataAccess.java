package com.shivintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shivintech.model.Reports;

public class ReportsDataAccess
{
	private static String dbUrl="jdbc:mysql://localhost:3306/springmvc";
	  private static String dbUsername="babu";
	  private static String dbPassword="babu@123";
	  
	  private static Connection cn=null;
	  private static PreparedStatement ps=null;
	  private static Statement st = null;
	  
	  public static void insertDetails(Reports r)
		 {
			    try
			    {
					Class.forName("com.mysql.cj.jdbc.Driver");
					cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
					//step 3:prepared Statement
					ps = cn.prepareStatement("insert into Reports(rid,rdata) values(?,?)");
	// To get value present in bean class private variable we will use getter methods because we are using Doctor input type in method.
		           ps.setInt(1, r.getRid());	
		           ps.setString(2,r.getRdata());
		          
		           
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
	  
	  public ArrayList<Reports> getReportsData()
	  {
		  ArrayList<Reports> al = new ArrayList<Reports>();	 
		   try
		    {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
				
				st = cn.createStatement();
				ResultSet rs =st.executeQuery("select* from Reports");
				// if row is present return row or else return false
				while(rs.next())
				{
				  int i = rs.getInt("rid"); // while retrieving we will retrieve id also.
				  String n = rs.getString("rdata");
				 
				  
				  // To enter data into ArrayList first create  object and with that var add to ArrayList.
				  Reports d = new Reports(i,n);
				   al.add(d); //for each row one object will enter into array list	  
				 }    
			} 
		    catch (ClassNotFoundException | SQLException e)
		    {
				e.printStackTrace();
			}
		    finally
		    {
		    	if(st!=null) // To avoid null pointer Exception
				{
					try
					{
						st.close();
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
		 	  
	  return al;
}			  
		 
}
