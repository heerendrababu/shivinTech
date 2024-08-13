package com.shivintech.model;

public class BookedDoctor 
{
   private int doctorId;
   private String doctorName;
   private String doctorProfession;
   private String doctorEmail;
   private String doctorMobile;
   private String appointmentDate;
public BookedDoctor(int doctorId, String doctorName, String doctorProfession, String doctorEmail,String doctorMobile,
		String appointmentDate) {
	super();
	this.doctorId = doctorId;
	this.doctorName = doctorName;
	this.doctorProfession = doctorProfession;
	this.doctorEmail=doctorEmail;
	this.doctorMobile = doctorMobile;
	this.appointmentDate = appointmentDate;
}
public BookedDoctor(String doctorName, String doctorProfession,String doctorEmail, String doctorMobile, String appointmentDate) {
	super();
	this.doctorName = doctorName;
	this.doctorProfession = doctorProfession;
	this.doctorEmail= doctorEmail;
	this.doctorMobile = doctorMobile;
	this.appointmentDate = appointmentDate;
}
public BookedDoctor() {
	super();
	// TODO Auto-generated constructor stub
}
public int getDoctorId() {
	return doctorId;
}
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getDoctorProfession() {
	return doctorProfession;
}
public void setDoctorProfession(String doctorProfession) {
	this.doctorProfession = doctorProfession;
}

public String getDoctorEmail() {
	return doctorEmail;
}
public void setDoctorEmail(String doctorEmail) {
	this.doctorEmail = doctorEmail;
}
public String getDoctorMobile() {
	return doctorMobile;
}
public void setDoctorMobile(String doctorMobile) {
	this.doctorMobile = doctorMobile;
}
public String getAppointmentDate() {
	return appointmentDate;
}
public void setAppointmentDate(String appointmentDate) {
	this.appointmentDate = appointmentDate;
}
   
   
}
