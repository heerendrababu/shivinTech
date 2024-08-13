package com.shivintech.model;

public class Doctor
{
  private int did;
  private String name;
  private String email;
  private String profession;
  private String password;
  private long mobile;
public Doctor(int did, String name, String email, String profession, String password, long mobile) {
	super();
	this.did = did;
	this.name = name;
	this.email= email;
	this.profession = profession;
	this.password = password;
	this.mobile = mobile;
}
public Doctor(String name, String email, String profession, String password, long mobile) {
	super();
	this.name = name;
	this.email= email;
	this.profession = profession;
	this.password = password;
	this.mobile = mobile;
}
public Doctor()
{
	super();
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
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
public String getProfession() {
	return profession;
}
public void setProfession(String profession) {
	this.profession = profession;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
  
}
