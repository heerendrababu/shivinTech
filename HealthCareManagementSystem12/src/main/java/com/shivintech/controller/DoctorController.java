package com.shivintech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shivintech.dao.AdminDataAccess;
import com.shivintech.dao.DoctorDataAccess;
import com.shivintech.dao.PatientDataAccess;
import com.shivintech.dao.ReportsDataAccess;
import com.shivintech.model.Doctor;
import com.shivintech.model.Patient;
import com.shivintech.model.Reports;

@Controller
public class DoctorController 
{
//  @RequestMapping(value = "doctor" ,params = "Ddetails")
//  public ModelAndView gotoRegistrationPage(HttpServletRequest request)
//  {
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("register.jsp");
//	return mv;
//   }
//  @RequestMapping(value = "bookAppointment" , params = "book")
//  public ModelAndView getAllDoctorDetails()
//  {
//	  ModelAndView mv = new ModelAndView();
//	  
//	  DoctorDataAccess da = new DoctorDataAccess();
//	  ArrayList<Doctor> al = da.getAllDoctorDetails();
//	 
//	  // used for sending above ArrayList data to frontEnd. which is used by getAttribute()
//	  mv.addObject("list",al); // getAttribute uses("variable", object);
//	  mv.setViewName("BookDoctor.jsp");
//	  
//	  return mv;
//	  
//  }
// @RequestMapping("reg")
// // 1] Reading data from FrontENd 
// public ModelAndView insertDoctorDetails(HttpServletRequest request) // it will return all data in string format
// {
//	String n = request.getParameter("dName");
//	String e = request.getParameter("dEmail");
//	String pr = request.getParameter("dProfess");
//	String pass = request.getParameter("dPass");
//    long m = Long.parseLong(request.getParameter("dMobile"));
//    
//    Doctor d = new Doctor(n,e,pr,pass,m); //2] read data  store it in model
//    DataAccess.insertDoctorDetails(d);
//    
//    ModelAndView mv = new ModelAndView();
//    
//    // we are sending data from Backend to FrontEnd so we nee to use addObject() method.
//    mv.addObject("res","inserted");
//    mv.setViewName("register.jsp");// after adding data redirecting user to same page
//    return mv;
//	 
// }
	
////////////////////////////////////////////////
//	@RequestMapping("dlogin")
//	   public ModelAndView insertAdminDetails(HttpServletRequest request)
//	   {
//		   ModelAndView mv = new ModelAndView();
//		   String e=request.getParameter("tbEmail");
//		   String p=request.getParameter("tbPass");
//		   
//		   boolean result=DataAccess.checkAdminLogin(e, p);
//			
//			if(result == true)
//			{
//				//if admin details correct,now open the "welcome page"
//				   mv.setViewName("welcomeAdmin.jsp");
//			}	
//			else
//			{
//            mv.setViewName("Admin.jsp");	   
//			
//	     	}
//			return mv;
//     }
	@RequestMapping("dlogin")
	   public ModelAndView insertDoctorDetails(HttpServletRequest request)
	   {
		   ModelAndView mv = new ModelAndView();
		   String e=request.getParameter("dEmail");
		   String p=request.getParameter("dPass");
		   
		   boolean result=DoctorDataAccess.checkDoctorLogin(e, p);
			
			if(result == true)
			{
				//if admin details correct,now open the "welcome page"
				   mv.setViewName("WelcomeDoctor.jsp");
			}	
			else
			{
            mv.setViewName("Doctor.jsp");	   
			
	     	}
			return mv;
      }
	
	@RequestMapping(value = "/sendReportAction", method = RequestMethod.POST)
    public ModelAndView sendReport(HttpServletRequest request,
                                   @RequestParam("reportText") String reportText) {
        ModelAndView mv = new ModelAndView();

        // Example: Process reportText if needed
        System.out.println("Report Text: " + reportText);

        // Example: Set a success message attribute
        mv.addObject("reportResult", "Report sent successfully!");

        // Specify the view name to redirect to (Success.jsp or another view)
        mv.setViewName("reportForm"); // Assuming you want to redirect back to the form

        return mv;	    }
	}



