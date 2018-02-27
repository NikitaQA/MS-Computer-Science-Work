package com.npu.myproject.services;

import java.util.List;

import com.npu.myproject.domain.Flight;

public interface FlightService {
	 List<Flight> selectFlightsbyStartAndEndAirport(String start_airport,String end_airport);
	  
	  Flight selectFlightById(Integer id);
	  public void addNewFlight(Flight flight);
	  

}
