package com.shivintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shivintech.model.Doctor;
import com.shivintech.model.Patient;

public class PatientDataAccess 
{
	  private static String dbUrl="jdbc:mysql://localhost:3306/springmvc";
	  private static String dbUsername="babu";
	  private static String dbPassword="babu@123";
	  
	  private static Connection cn=null;
	  private static PreparedStatement ps=null;
	  private static Statement st = null;
	  
	  // Insert Patient details into 'DB' when he clicks register
	  public static void insertPatientDetail(Patient pd)
		 {
			    try
			    {
					Class.forName("com.mysql.cj.jdbc.Driver");
					cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
					//step 3:prepared Statement
					ps = cn.prepareStatement("insert into patient(pid,name,email,password,gender) values(?,?,?,?,?)");
	// To get value present in bean class private variable we will use getter methods because we are using Patient input type in method.
		            ps.setInt(1, pd.getPid());
		            ps.setString(2, pd.getName());
		            ps.setString(3, pd.getEmail());
		            ps.setString(4, pd.getPassword());
		            ps.setString(5, pd.getGender());
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
	 
	  		//(2)to check the Patient details correct or not
	  		public static  boolean checkPatientLogin(String e, String p) 
	  		{
	  			
	  			//2.JDBC code read all rows from admin table
	  				
	  			   try 
	  			    {
	  				Class.forName("com.mysql.cj.jdbc.Driver");
	  				cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
	  				 st=cn.createStatement();
	  				 ResultSet rs=st.executeQuery("select*from patient");
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
	  			 
	  				return false;//Patient login failure	
	  		}

	  		 // (3) get all Doctor details from db and return to controller
			 public ArrayList<Patient> getAllPatientDetails()
			 {
				 ArrayList<Patient> al = new ArrayList<Patient>();	 
			   try
			    {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					cn	=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);  
					
					st = cn.createStatement();
					ResultSet rs =st.executeQuery("select* from patient");
					// if row is present return row or else return false
					while(rs.next())
					{
					  int i = rs.getInt("pid"); // while retrieving we will retrieve id also.
					  String n = rs.getString("name");
					  String e = rs.getString("email");
					  String pass = rs.getString("password");
					  String gen= rs.getString("gender");
					  
					  // To enter data into ArrayList first create  object and with that var add to ArrayList.
					  Patient d = new Patient(i,n,e,pass,gen);
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
