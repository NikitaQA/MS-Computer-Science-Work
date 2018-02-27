package com.npu.myproject.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// XmlElement sets the name of the entities
	@XmlElement(name = "Flight")
	private List<Flight> flightList1 ;

	public FlightList() {
	}
	
	public List<Flight> getFlightList1() {
		return flightList1;
	}

	public void setFlightList1(List<Flight> newflightList1) {
		this.flightList1 = newflightList1;
	}
	
	public int numEntries() {
		if (flightList1 == null) return 0;
		return flightList1.size();
	}
	
	public Flight getFlight(int idx) {
		return flightList1.get(idx);
	}
	
	public String toString() {
		String listStr;
		
		listStr = "flightList1{";
		for (Flight entry: flightList1) {
			listStr = listStr + "\n\t" + entry;
		}
		
		listStr = listStr + "\n}";
		return listStr;
	}
}