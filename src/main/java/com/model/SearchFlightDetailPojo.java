package com.model;

import java.time.LocalDate;
import java.util.Date;

public class SearchFlightDetailPojo {
	
	private String sourceCityName;
	private String destinationCityName;
	private LocalDate travelDate;
	private int noOfPassengers;
	public String getSourceCityName() {
		return sourceCityName;
	}
	public void setSourceCityName(String sourceCityName) {
		this.sourceCityName = sourceCityName;
	}
	
	public String getDestinationCityName() {
		return destinationCityName;
	}
	public void setDestinationCityName(String destinationCityName) {
		this.destinationCityName = destinationCityName;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	@Override
	public String toString() {
		return "searchPojo [sourceCityName=" + sourceCityName + ", DestinationCityName=" + destinationCityName
				+ ", travelDate=" + travelDate + ", noOfPassengers=" + noOfPassengers + "]";
	}
	
	

}
