package com.npu.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




import com.npu.myproject.domain.Flight;
import com.npu.myproject.domain.FlightList;
import com.npu.myproject.forms.Form;
import com.npu.myproject.services.FlightService;


@Controller
public class FlightController {
@Autowired
FlightService flightservice;


private static final Logger logger = LoggerFactory.getLogger(FlightController.class);


	@RequestMapping(value="/bookFlight",method= RequestMethod.POST)
	public ModelAndView bookFlighsuccess(){
		ModelAndView modelView;
		modelView = new ModelAndView("flightBookingSuccess");
		
		return modelView;
	}
	
		@RequestMapping(value="/selectflightform",method= RequestMethod.GET)
		public ModelAndView selectFlighForm(){
			ModelAndView modelView;
			modelView = new ModelAndView("selectFlightDataForm");
			modelView.addObject("flight", new Flight());
			return modelView;
		}
	@RequestMapping(value="/processEnteredFlightInformation", method=RequestMethod.POST)
	public ModelAndView processSelectedFlight(HttpServletRequest r,HttpSession session){
		ModelAndView modelView;
		
		 List<Flight> flightList22= flightservice.selectFlightsbyStartAndEndAirport(r.getParameter("start_airport"),r.getParameter("end_airport"));
		System.out.println(r.getParameter("start_airport")+r.getParameter("end_airport")+flightList22);
		FlightList flightList = new FlightList();
		flightList.setFlightList1(flightservice.selectFlightsbyStartAndEndAirport
				(r.getParameter("start_airport"),r.getParameter("end_airport")));
		
		modelView= new ModelAndView("displaySelectedFlight", "flightList", flightList);
		
		return modelView;
		
		
		
	}


}