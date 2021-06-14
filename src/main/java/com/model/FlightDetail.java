package com.model;



import java.time.LocalTime;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightdetail")
public class FlightDetail {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightId;
	
	@ManyToOne(targetEntity = TripSourceDestination.class, cascade = CascadeType.ALL)
	@JoinColumn(name="tripId")
	private TripSourceDestination tripSrcDest;
	
	@ManyToOne(targetEntity= Airline.class,cascade = CascadeType.ALL)
	@JoinColumn(name="AirlineId")
	private Airline airline;
	
	
	  @OneToOne(targetEntity = FlightRunningDays.class,cascade =  CascadeType.ALL,fetch=FetchType.EAGER)	  
	  @JoinColumn(name="flightScheduleId") 
	  private FlightRunningDays flightRunningDays;
	 
	
	private double ticketPrice;
	
//	@Temporal(TemporalType.TIME)
	private LocalTime departureTime;
	
//	@Temporal(TemporalType.TIME)
	private LocalTime travelDuration;
	
	

	

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	


	
	  public FlightRunningDays getFlightRunningDays() { return flightRunningDays; }
	  
	  public void setFlightRunningDays(FlightRunningDays flightRunningDays) {
	  this.flightRunningDays = flightRunningDays; }
	 
	public TripSourceDestination getTripSrcDest() {
		return tripSrcDest;
	}

	public void setTripSrcDest(TripSourceDestination tripSrcDest) {
		this.tripSrcDest = tripSrcDest;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}



	

	

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(LocalTime travelDuration) {
		this.travelDuration = travelDuration;
	}



	public FlightDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FlightDetail(int flightId, TripSourceDestination tripSrcDest, Airline airline,
			FlightRunningDays flightRunningDays, double ticketPrice, LocalTime departureTime,
			LocalTime travelDuration) {
		super();
		this.flightId = flightId;
		this.tripSrcDest = tripSrcDest;
		this.airline = airline;
		this.flightRunningDays = flightRunningDays;
		this.ticketPrice = ticketPrice;
		this.departureTime = departureTime;
		this.travelDuration = travelDuration;
	}

	@Override
	public String toString() {
		return "FlightDetail [flightId=" + flightId + ", tripSrcDest=" + tripSrcDest + ", airline=" + airline
				+ ", flightRunningDays=" + flightRunningDays + ", ticketPrice=" + ticketPrice + ", departureTime="
				+ departureTime + ", travelDuration=" + travelDuration + "]";
	}



	
	
}
