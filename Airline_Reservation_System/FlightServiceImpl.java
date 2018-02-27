package com.npu.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.myproject.dao.FlightDao;
import com.npu.myproject.domain.Flight;
@Service("flightservice")
@Transactional(readOnly=true)
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightDao flightdao;
	public FlightServiceImpl(){
		System.out.println("instantiated");
	}

	@Transactional
	public List<Flight> selectFlightsbyStartAndEndAirport(String start_airport,String end_airport) {
		List<Flight> flightList=flightdao.selectFlights(start_airport, end_airport);
		System.out.println("from service" +flightList);
		
		return flightList;
	}

@Transactional
	public Flight selectFlightById(Integer id) {
		Flight flight=flightdao.selectFlightById(id);
		return flight;
	}
@Transactional
public void addNewFlight(Flight flight){
	flightdao.insertFlight(flight);
}
}