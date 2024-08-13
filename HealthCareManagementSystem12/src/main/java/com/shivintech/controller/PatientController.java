package com.shivintech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shivintech.dao.AdminDataAccess;
import com.shivintech.dao.PatientDataAccess;
import com.shivintech.model.Patient;

@Controller
public class PatientController 
{
// Redirecting to Patient Registration
// @RequestMapping(value = "patient" ,params ="reg")
// public ModelAndView RegisterPatient()
// {
//	    ModelAndView mv = new ModelAndView();
//	    mv.setViewName("PatientRegistration.jsp");
//		return mv;
// }
 // After Registering showing Back to Home option
 @RequestMapping(value ="backtologin" , params = "back")
 public ModelAndView backtoPatientLogin()
 {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("Patient.jsp");
	    return mv;

 }
 
 // After clicking Register enter patient data to 'DB'
 @RequestMapping("insertpatient")
 public ModelAndView insertPatient(HttpServletRequest request)
 {
     
     ModelAndView mv = new ModelAndView();

     String name  = request.getParameter("name");
     String email = request.getParameter("email");
     String pass  = request.getParameter("password");
     String gen   = request.getParameter("gender"); // Assuming gender is a String
     
       Patient p = new Patient(name,email,pass,gen);
	   PatientDataAccess.insertPatientDetail(p);
	   // check if email id is same or not
//	   if(email.equals(p.getEmail()))
//	   {
//		   mv.addObject("message", "same Email id is already registered");
//		   mv.setViewName("Success.jsp");
//		  
//	    }
//	   else
//	   {
	    // we are sending data from Backend to FrontEnd so we nee to use addObject() method.
	   mv.addObject("message", "Patient added successfully: " + p.getName());
        mv.setViewName("Success.jsp");// after adding data redirecting user to same page
	 //  }
	return mv;
 }

 // Check Patient login credentials and redirecting him to welcome user page
 
 @RequestMapping(value = "patient", params = "login")
 public ModelAndView checkPatient(HttpServletRequest request)
 {
	   ModelAndView mv = new ModelAndView();
	   String e=request.getParameter("tbEmail");
	   String p=request.getParameter("tbPass");
	   
	   boolean result=PatientDataAccess.checkPatientLogin(e, p);
		
		if(result == true)
		{
			//if admin details correct,now open the "welcome page"
			   mv.setViewName("WelcomeUser.jsp");
		}	
		else
		{
		 mv.addObject("check","Credentials are Wrong Please try again");
         mv.setViewName("Verification.jsp");	   
		
   	}
		return mv;
  }
	// Getting Doctor Details
 @RequestMapping(value = "dlogin" , params = "GetPatientDetails")
 public ModelAndView getPatientDetails()
 {
	  ModelAndView mv = new ModelAndView();
	  
	  PatientDataAccess pd = new PatientDataAccess();
	  ArrayList<Patient> al = pd. getAllPatientDetails();
	 
	  // used for sending above ArrayList data to frontEnd. which is used by getAttribute()
	  mv.addObject("patientlist",al); // getAttribute uses("variable", object);
	  mv.setViewName("WelcomeDoctor.jsp");
	  
	  return mv;
		  
	  
 }
}
