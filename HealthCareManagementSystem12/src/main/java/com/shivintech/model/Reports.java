package com.shivintech.model;

public class Reports 
{
  int rid;
  String rdata;
public Reports(int rid, String rdata) {
	super();
	this.rid = rid;
	this.rdata = rdata;
}
public Reports() {
	super();
	// TODO Auto-generated constructor stub
}
public Reports(String rdata) {
	super();
	this.rdata = rdata;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getRdata() {
	return rdata;
}
public void setRdata(String rdata) {
	this.rdata = rdata;
}
  
  
}
