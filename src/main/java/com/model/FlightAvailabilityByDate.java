package com.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="flightavailabilitybydate")
public class FlightAvailabilityByDate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightTripId;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="flightId")
	private FlightDetail flightdetail;
	
	private LocalDate travelDate;
	
	private int noOfTickets;
	
	
	
	public int getFlightTripId() {
		return flightTripId;
	}
	public void setFlightTripId(int flightTripId) {
		this.flightTripId = flightTripId;
	}
	public FlightDetail getFlightdetail() {
		return flightdetail;
	}
	public void setFlightdetail(FlightDetail flightdetail) {
		this.flightdetail = flightdetail;
	}
	
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	
	public FlightAvailabilityByDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlightAvailabilityByDate(FlightDetail flightdetail, LocalDate travelDate, int noOfTickets) {
		super();
		this.flightdetail = flightdetail;
		this.travelDate = travelDate;
		this.noOfTickets = noOfTickets;
	}
	@Override
	public String toString() {
		return "FlightAvailabilityByDate [flightTripId=" + flightTripId + ", flightdetail=" + flightdetail
				+ ", travelDate=" + travelDate + ", noOfTickets=" + noOfTickets + "]";
	}
	
	
}
