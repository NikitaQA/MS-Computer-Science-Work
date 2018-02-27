package com.npu.myproject.domain;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement(name = "flight")
public class Flight {
	
	private int id;
	@Size(min=2, max=30)
	private String airline;
	@NotEmpty
	private String start_airport;
	@NotEmpty
	private String startTime;
	@NotEmpty
	private String end_airport;
	private String endTime;
	private int stops;
	
	private String returnstart_airport;
	private String returnStartTime;
	private String returnend_airport;
	private String returnEndTime;
	private int returnStops;
	
	private int price;
	public Flight(){}
	
	public Flight(String airline,String start_airport,String startTime,String end_airport,String endTime
			,int stops,String returnstart_airport,String returnStartTime,String returnend_airport,String returnEndTime,
			int returnStops,int price){
		
		this.airline=airline;
		this.start_airport=start_airport;
		this.startTime=startTime;
		this.end_airport=end_airport;
		this.endTime=endTime;
		this.stops=stops;
		this.returnstart_airport=returnstart_airport;
		this.returnStartTime=returnStartTime;
		this.returnend_airport=returnend_airport;
		this.returnEndTime=returnEndTime;
		this.returnStops=returnStops;
		this.price=price;
		
	}
	
	

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getId() {
	    return id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}
	public String getstart_airport() {
		return start_airport;
	}

	public void setstart_airport(String start_airport) {
		this.start_airport = start_airport;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getend_airport() {
		return end_airport;
	}

	public void setend_airport(String end_airport) {
		this.end_airport = end_airport;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getReturnstart_airport() {
		return returnstart_airport;
	}

	public void setReturnstart_airport(String returnstart_airport) {
		this.returnstart_airport = returnstart_airport;
	}

	public String getReturnStartTime() {
		return returnStartTime;
	}

	public void setReturnStartTime(String returnStartTime) {
		this.returnStartTime = returnStartTime;
	}

	public String getReturnend_airport() {
		return returnend_airport;
	}

	public void setReturnend_airport(String returnend_airport) {
		this.returnend_airport = returnend_airport;
	}

	public String getReturnEndTime() {
		return returnEndTime;
	}

	public void setReturnEndTime(String returnEndTime) {
		this.returnEndTime = returnEndTime;
	}

	public int getReturnStops() {
		return returnStops;
	}

	public void setReturnStops(int returnStops) {
		this.returnStops = returnStops;
	}
	  


}
