package com.npu.myproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.myproject.domain.Flight;

public class FlightRowMapper implements RowMapper<Flight>{

	@Override
	public Flight mapRow(ResultSet resultset, int rows) throws SQLException {
		
		
		 String airline;
		 String startAirport;
		 String startTime;
		 String endAirport;
		 String endTime;
		 int stops;
		
		 String returnStartAirport;
		 String returnStartTime;
		 String returnEndAirport;
		 String returnEndTime;
		 int returnStops;
		
		 int price;
		 
		 Flight flight;
		 
		 airline=resultset.getString("airline");
		 startAirport=resultset.getString("start_Airport");
		 startTime=resultset.getString("start_Time");
		 endAirport=resultset.getString("end_Airport");
		 endTime=resultset.getString("end_Time");
		 stops=resultset.getInt("stops");
		 returnStartAirport=resultset.getString("return_Start_Airport");
		 returnStartTime=resultset.getString("return_Start_Time");
		 returnEndAirport=resultset.getString("return_End_Airport");
		 returnEndTime=resultset.getString("return_End_Time");
		 returnStops=resultset.getInt("return_Stops");
		 price=resultset.getInt("price");
		 
		  flight= new Flight( airline, startAirport, startTime, endAirport, endTime
					, stops, returnStartAirport, returnStartTime, returnEndAirport, returnEndTime,
					 returnStops, price);
		  
		  
		  
		  return flight;
		  		
	}
	

}
