package com.shivintech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shivintech.dao.AdminDataAccess;
import com.shivintech.dao.DoctorDataAccess;
import com.shivintech.model.Doctor;

@Controller 
public class AdminController 
{
	@RequestMapping("adminlogin")
	   public ModelAndView insertAdminDetails(HttpServletRequest request)
	   {
		   ModelAndView mv = new ModelAndView();
		   String e=request.getParameter("tbEmail");
		   String p=request.getParameter("tbPass");
		   
		   boolean result=AdminDataAccess.checkAdminLogin(e, p);
			
			if(result == true)
			{
				//if admin details correct,now open the "welcome page"
				   mv.setViewName("welcomeAdmin.jsp");
			}	
			else
			{
	           mv.addObject("ErrorMessage", "False information, please enter the right credentials.");
               mv.setViewName("Admin.jsp");	   
			
	     	}
			return mv;
        }
	@RequestMapping(value = "doctor" ,params = "Ddetails")
	  public ModelAndView gotoRegistrationPage(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("register.jsp");
		return mv;
	   }
	
	// Getting Doctor Details
	  @RequestMapping(value = "doctor" , params = "getdoctorslist")
	  public ModelAndView getAllDoctorDetails()
	  {
		  ModelAndView mv = new ModelAndView();
		  
		  DoctorDataAccess da = new DoctorDataAccess();
		  ArrayList<Doctor> al = da.getAllDoctorDetails();
		 
		  // used for sending above ArrayList data to frontEnd. which is used by getAttribute()
		  mv.addObject("list",al); // getAttribute uses("variable", object);
		  mv.setViewName("display.jsp");
		  
		  return mv;
		  
	  }
	  
	 // Inserting Doctor Details
	 @RequestMapping("reg")
	 // 1] Reading data from FrontENd 
	 public ModelAndView insertDoctorDetails(HttpServletRequest request) // it will return all data in string format
	 {
		String n = request.getParameter("dName");
		String e = request.getParameter("dEmail");
		String pr = request.getParameter("dProfess");
		String pass = request.getParameter("dPass");
	    long m = Long.parseLong(request.getParameter("dMobile"));
	    
	    Doctor d = new Doctor(n,e,pr,pass,m); //2] read data  store it in model
	    DoctorDataAccess.insertDoctorDetails(d);
	    
	    ModelAndView mv = new ModelAndView();
	    
	    // we are sending data from Backend to FrontEnd so we nee to use addObject() method.
	    mv.addObject("res","inserted");
	    mv.setViewName("register.jsp");// after adding data redirecting user to same page
	    return mv;
	 }
//----------------------------------------------------------------------------------------
	 // TO edit doctor data
	 @RequestMapping("edit")
	 public ModelAndView displayEditForm(int did)
	 {
		ModelAndView mv = new ModelAndView();
		// step 1: Retrieve the old data from DB
		DoctorDataAccess da = new  DoctorDataAccess();
		Doctor doc = da.getDoctorById(did);// data must come from url/browser,so give id in method input.
		mv.addObject("doctor",doc); // redirect user to register page.
		
		// step 2: Redirect user to edit form[register.jsp]
		// to display the old data in controls.
		mv.setViewName("register.jsp");
		
		return mv;	 
	 }
	 
//------------------------------------------------------------------------------------------	
 // To update edited doctor data in DB
	 @RequestMapping("update")
	 public ModelAndView updateDoctorData(HttpServletRequest request)
	 {
		 ModelAndView mv = new ModelAndView();
		 // 1)Reading the data from register.jsp page
		 int did = Integer.parseInt(request.getParameter("dId"));// converting string into Integer
		 String name  =  request.getParameter("dName");
		 String email =   request.getParameter("dEmail");
		 String profession =   request.getParameter("dProfess");
		 String password = request.getParameter("dPass");
		 long mob = Long.parseLong(request.getParameter("dMobile"));
		 
		 // After reading data in above then store it in Doctor object
    Doctor dobj = new Doctor(did,name,email,profession,password,mob); // calling constructor with id parameter
		 
		 // 2) update the value in DB
		    DoctorDataAccess da = new DoctorDataAccess();
	        da.updateDoctorDetails(dobj);
	        
		 // 3) Redirect admin to display.jsp with updated values
		 ArrayList<Doctor> al = da.getAllDoctorDetails();
		 
		  // used for sending above ArrayList data to frontEnd. which is used by getAttribute()
		  mv.addObject("list",al); // getAttribute uses("variable", object);
		  mv.setViewName("display.jsp");
		 return mv;
		 
	 }
	 
// deleting a row of doctor by using id and get the id from frontEnd by url
	 @RequestMapping("delete")
	 public ModelAndView deleteDoctorData(int did)// read data from url and give data to below delete method.
	 {
		 ModelAndView mv = new ModelAndView();
		 
	//step 1: call the delete method present in DataAccess layer.
		 DoctorDataAccess da = new DoctorDataAccess();
		 da.delete(did);
		 
   //step 2: redirect user to display.jsp with remaining rows leftout in table.
		 ArrayList<Doctor> al = da.getAllDoctorDetails();
		 
		  // used for sending above ArrayList data to frontEnd. which is used by getAttribute()
		  mv.addObject("list",al); // getAttribute uses("variable", object);
		  mv.setViewName("display.jsp");
		 
		  return mv; 
		 
	 }
	 
}