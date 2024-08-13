package com.shivintech.model;


public class Patient 
{
 private int pid;
 private String name;
 private String email;
 private String password;
 private String gender;
public Patient(int pid, String name, String email, String password, String gender) {
	super();
	this.pid = pid;
	this.name = name;
	this.email = email;
	this.password = password;
	this.gender = gender;
}
public Patient(String name, String email, String password, String gender) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.gender = gender;
}

public Patient() 
{
	super();
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

 
 

  
}
