package com.shivintech.dao;

// The DAO (Data Access Object) layer in software development provides an interface 
//to interact with a database or any other persistence mechanism, encapsulating the details of accessing the data.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shivintech.model.Doctor;

public class AdminDataAccess 
{
	  private static String dbUrl="jdbc:mysql://localhost:3306/springmvc";
	  private static String dbUsername="babu";
	  private static String dbPassword="babu@123";
	  
	  private static Connection cn=null;
	  private static PreparedStatement ps=null;
	  private static Statement st = null;
	  

		//(1)to check the admin details correct or not
		public static  boolean checkAdminLogin(String e, String p) 
		{
			
			//2.JDBC code read all rows from admin table
				
			   try 
			    {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				 st=cn.createStatement();
				 ResultSet rs=st.executeQuery("select*from admin");
				 int count=0;
				 if(rs!=null)
				 {
					 while(rs.next()== true)
					 {
						String dbemail= rs.getString(3);
						String dbpass=rs.getString(4);
						if(dbemail.equals(e) && dbpass.equals(p))
						{
							count++;
							break;
						}
					 }
				 }
				 if (count ==1)
				    return true;
				 else
					 return false;
				 
			     }
			   catch (ClassNotFoundException | SQLException e1)
			   {
				e1.printStackTrace();
			   }
			   finally
			    {
			    	if(ps!=null)
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
			 
				return false;//admin login failure	
		}
//	// (2) write jdbc code for inserting doctor Data into DB
//	 public static void insertDoctorDetails(Doctor d)
//	 {
//		    try
//		    {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
//				//step 3:prepared Statement
//				ps = cn.prepareStatement("insert into doctor(id,name,email,profession,password,mob) values(?,?,?,?,?,?)");
//// To get value present in bean class private variable we will use getter methods because we are using Doctor input type in method.
//	           ps.setInt(1, d.getId());	
//	           ps.setString(2, d.getName());
//	           ps.setString(3, d.getEmail());
//	           ps.setString(4, d.getProfession());
//	           ps.setString(5, d.getPassword());
//	           ps.setLong(6, d.getMobile());
//	           
//	           ps.executeUpdate();
//	
//			     
//			} 
//		    catch (ClassNotFoundException | SQLException e)
//		    {
//				e.printStackTrace();
//			}
//		    finally
//		    {
//		    	if(ps!=null) // To avoid null pointer Exception
//				{
//					try
//					{
//						ps.close();
//					} 
//					catch (SQLException e1)
//					{
//						e1.printStackTrace();
//					}
//				}
//				if(cn!=null)
//				{
//					try
//					{
//						cn.close();
//					}
//					catch (SQLException e1) 
//					{
//						e1.printStackTrace();
//					}
//				}
//		    }
//	   }
//	 
//	 // (3) get all Doctor details from db and return to controller
//	 public ArrayList<Doctor> getAllDoctorDetails()
//	 {
//		 ArrayList<Doctor> al = new ArrayList<Doctor>();	 
//	   try
//	    {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
//			
//			st = cn.createStatement();
//			ResultSet rs =st.executeQuery("select* from Doctor");
//			// if row is present return row or else return false
//			while(rs.next())
//			{
//			  int i = rs.getInt("id"); // while retrieving we will retrieve id also.
//			  String n = rs.getString("name");
//			  String e = rs.getString("email");
//			  String pr = rs.getString("profession");
//			  String pass= rs.getString("password");
//			  long mob = rs.getLong("mob");
//			  
//			  // To enter data into ArrayList first create  object and with that var add to ArrayList.
//			  Doctor d = new Doctor(i,n,e,pr,pass,mob);
//			   al.add(d); //for each row one object will enter into array list	  
//			 }    
//		} 
//	    catch (ClassNotFoundException | SQLException e)
//	    {
//			e.printStackTrace();
//		}
//	    finally
//	    {
//	    	if(st!=null) // To avoid null pointer Exception
//			{
//				try
//				{
//					st.close();
//				} 
//				catch (SQLException e1)
//				{
//					e1.printStackTrace();
//				}
//			}
//			if(cn!=null)
//			{
//				try
//				{
//					cn.close();
//				}
//				catch (SQLException e1) 
//				{
//					e1.printStackTrace();
//				}
//			}
//	    }
//	  return al;
//	 }	  
//	
//	
//	public static  boolean checkDoctorLogin(String e, String p) 
//	{
//		
//		//2.JDBC code read all rows from doctor table
//			
//		   try 
//		    {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
//			 st=cn.createStatement();
//			 ResultSet rs=st.executeQuery("select*from doctor");
//			 int count=0;
//			 if(rs!=null)
//			 {
//				 while(rs.next()== true)
//				 {
//					String dbemail= rs.getString(3);
//					String dbpass=rs.getString(5);
//					if(dbemail.equals(e) && dbpass.equals(p))
//					{
//						count++;
//						break;
//					}
//				 }
//			 }
//			 if (count ==1)
//			    return true;
//			 else
//				 return false;
//			 
//		     }
//		   catch (ClassNotFoundException | SQLException e1)
//		   {
//			e1.printStackTrace();
//		   }
//		   finally
//		    {
//		    	if(ps!=null)
//				{
//					try
//					{
//						ps.close();
//					} 
//					catch (SQLException e1)
//					{
//						e1.printStackTrace();
//					}
//				}
//				if(cn!=null)
//				{
//					try
//					{
//						cn.close();
//					}
//					catch (SQLException e1) 
//					{
//						e1.printStackTrace();
//					}
//				}
//		    }
//		 
//			return false;//admin login failure
//	 
//	
//	}
	
}
