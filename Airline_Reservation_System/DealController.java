package com.npu.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.DealList;
import com.npu.myproject.domain.Flight;
import com.npu.myproject.domain.FlightList;
import com.npu.myproject.services.DealService;

@Controller
public class DealController {
	@Autowired
	DealService dealservice;
	private static final Logger logger = LoggerFactory.getLogger(DealController.class);
	
		

		//Process the deleted flight operation
		@RequestMapping(value="findDealform",method= RequestMethod.GET)
		public ModelAndView processDealForm(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			List<Deal> dealList22= dealservice.selectDeals();
			DealList dealList=new DealList();
			dealList.setdealList1(dealservice.selectDeals());
			
			modelView= new ModelAndView("findDealProfileSuccess","dealList",dealList);
			return modelView;
		}
	

}
