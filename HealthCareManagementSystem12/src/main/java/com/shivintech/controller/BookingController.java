package com.shivintech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shivintech.dao.BookedDoctorDataAccess;
import com.shivintech.dao.DoctorDataAccess;
import com.shivintech.model.BookedDoctor;
import com.shivintech.model.Doctor;

@Controller
public class BookingController 
{

	// Getting Doctor Details
	  @RequestMapping(value = "BookingController" , params = "book")
	  public ModelAndView getAllDoctorDetails()
	  {
		  ModelAndView mv = new ModelAndView();
		  
		  DoctorDataAccess da = new DoctorDataAccess();
		  ArrayList<Doctor> al = da.getAllDoctorDetails();
		 
		  // used for sending above ArrayList data to frontEnd. which is used by getAttribute()
		  mv.addObject("doctorlist",al); // getAttribute uses("variable", object);
		  mv.setViewName("BookDoctor.jsp");
		  
		  return mv;
			  
		  }
	  
	//     Getting Doctor Details
		  @RequestMapping("bookPatient")
		  public ModelAndView getBookedDoctorDetails(HttpServletRequest request)
		  {
			  ModelAndView mv = new ModelAndView();
			        
			  String n = request.getParameter("firstName");
			  String l = request.getParameter("lastName");
			  int age= Integer.parseInt(request.getParameter("age"));// converting string into Integer
			//char gender = request.getParameter("gender").charAt(0); // Get the first character
			  String g = request.getParameter("gender");
			  String b = request.getParameter("bloodGroup");
			  
			   mv.addObject("appointmentSuccess", "Appointment Booked Successfully: ");
               mv.setViewName("Success.jsp");
			  
			  return mv;
				  
			 }
		  
		
			  
		  }

	  

