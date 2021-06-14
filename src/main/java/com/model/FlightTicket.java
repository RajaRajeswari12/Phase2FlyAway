package com.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flightTicket")
public class FlightTicket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketId;
	
	private int flightNo;
	
	@OneToMany(targetEntity = PassengersDetail.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ticketId")
	private List<PassengersDetail> passengerList;
	
	private LocalDate travelDate;
	
	private String sourceCity;
	
	private String destinationCity;
	
	private LocalTime departureTime;
	
	private double totalFare;
	
	private int noOfPassenger;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public List<PassengersDetail> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<PassengersDetail> passengerList) {
		this.passengerList = passengerList;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	@Override
	public String toString() {
		return "FlightTicket [ticketId=" + ticketId + ", flightNo=" + flightNo + ", passengerList=" + passengerList
				+ ", travelDate=" + travelDate + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ ", departureTime=" + departureTime + ", totalFare=" + totalFare + ", noOfPassenger=" + noOfPassenger
				+ "]";
	}

}
