package com.npu.myproject.dao;



import java.util.List;

import com.npu.myproject.domain.Flight;
import com.npu.myproject.forms.Form;

public interface FlightDao {
	 List<Flight> selectFlights(String start_airport,String end_airport);
	  
	  Flight selectFlightById(Integer id);
	  public void insertFlight(Flight flight);
	  


}
