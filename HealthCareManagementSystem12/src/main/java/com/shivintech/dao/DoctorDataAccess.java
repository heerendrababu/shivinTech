package com.shivintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shivintech.model.Doctor;

public class DoctorDataAccess {
	private static String dbUrl = "jdbc:mysql://localhost:3306/springmvc";
	private static String dbUsername = "babu";
	private static String dbPassword = "babu@123";

	private static Connection cn = null;
	private static PreparedStatement ps = null;
	private static Statement st = null;

	// (2) write jdbc code for inserting doctor Data into DB
	public static void insertDoctorDetails(Doctor d) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			// step 3:prepared Statement
			ps = cn.prepareStatement("insert into doctor(did,name,email,profession,password,mob) values(?,?,?,?,?,?)");
			// To get value present in bean class private variable we will use getter
			// methods because we are using Doctor input type in method.
			ps.setInt(1, d.getDid());
			ps.setString(2, d.getName());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getProfession());
			ps.setString(5, d.getPassword());
			ps.setLong(6, d.getMobile());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) // To avoid null pointer Exception
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	// (3) get all Doctor details from db and return to controller
	public ArrayList<Doctor> getAllDoctorDetails() {
		ArrayList<Doctor> al = new ArrayList<Doctor>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

			st = cn.createStatement();
			ResultSet rs = st.executeQuery("select* from Doctor");
			// if row is present return row or else return false
			while (rs.next()) {
				int i = rs.getInt("did"); // while retrieving we will retrieve id also.
				String n = rs.getString("name");
				String e = rs.getString("email");
				String pr = rs.getString("profession");
				String pass = rs.getString("password");
				long mob = rs.getLong("mob");

				// To enter data into ArrayList first create object and with that var add to
				// ArrayList.
				Doctor d = new Doctor(i, n, e, pr, pass, mob);
				al.add(d); // for each row one object will enter into array list
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) // To avoid null pointer Exception
			{
				try {
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return al;
	}

	// (1) Check Doctor Login
	public static boolean checkDoctorLogin(String e, String p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			st = cn.createStatement();
			ResultSet rs = st.executeQuery("select*from doctor");
			int count = 0;
			if (rs != null) {
				while (rs.next() == true) {
					String dbemail = rs.getString(3);
					String dbpass = rs.getString(5);
					if (dbemail.equals(e) && dbpass.equals(p)) {
						count++;
						break;
					}
				}
			}
			if (count == 1)
				return true;
			else
				return false;

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return false;// admin login failure
	}

// edit doctor data
	public Doctor getDoctorById(int did) {
		Doctor d = new Doctor();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			// step 3:prepared Statement
			// we can't change id, once it gets it is fixed, but remaining data we can
			// change.
			ps = cn.prepareStatement("select * from Doctor where did = ?"); // here * means all columns of one row.
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			// we are reading only one student data so we dont need any while loop.
			if (rs.next()) { // Trying to store data inside doctor object 'd' and setting the values inside
								// doctor object.
				d.setDid(did);// read data from database and immediately storing it inside private variable of
								// docotor Object
				d.setName(rs.getString("name"));
				d.setEmail(rs.getString("email"));
				d.setProfession(rs.getString("profession"));
				d.setPassword(rs.getString("password"));
				d.setMobile(rs.getLong("mob"));
			}

		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) // To avoid null pointer Exception
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return d;
	}
	
	// update/edit doctor details by admin

		public static void updateDoctorDetails(Doctor d) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
				// step 3:prepared Statement
				// we can't change id, once it gets it is fixed, but remaining data we can
				// change.
				ps = cn.prepareStatement("update Doctor set name=?, email=?,profession=?,password=?,mob=? where did =? ");
				// To get value present in bean class private variable we will use getter
				// methods because we are using Doctor input type in method.
				ps.setString(1, d.getName());
				ps.setString(2, d.getEmail());
				ps.setString(3, d.getProfession());
				ps.setString(4, d.getPassword());
				ps.setLong(5, d.getMobile());
				ps.setInt(6, d.getDid());

				ps.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null) // To avoid null pointer Exception
				{
					try {
						ps.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (cn != null) {
					try {
						cn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

// delete doctor data by using id and  it doesn't return anything
	public void delete(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			// step 3:prepared Statement
			// we can't change id, once it gets it is fixed, but remaining data we can
			// change.
			ps = cn.prepareStatement("delete from Doctor where did =? ");
			
			// setting value for above question mark
			ps.setInt(1, id); // same as  parameter input

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) // To avoid null pointer Exception
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	
	}
		
}
