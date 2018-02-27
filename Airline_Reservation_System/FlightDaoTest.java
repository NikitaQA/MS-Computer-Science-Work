package com.npu.myproject.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.npu.myproject.dao.FlightDao;
import com.npu.myproject.domain.Flight;
import com.npu.myproject.forms.Form;

@ContextConfiguration("classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightDaoTest {
	@Autowired
	@Qualifier("flightDaoJdbc")
	private FlightDao flightDao;
	
	@Test
	public void testSelectedFlight(){
		
		Flight flight=new Flight("DELTA", "JFK", "9.35AM", "LHR", "1.35PM", 1, "LHR", "9.35AM", "JFK", "1.35PM", 0,1200);
		List<Flight> flightList=flightDao.selectFlights("JFK", "LHR");
		
	}
	
	@Test
	public void testSelectById(){
		Flight flight1;
		Flight flight=new Flight("DELTA", "JFK", "9.35AM", "LHR", "1.35PM", 1, "LHR", "9.35AM", "JFK", "1.35PM", 0,1200);
		flight1=flightDao.selectFlightById(2);
	}
	
	
	
	
	
	

}
