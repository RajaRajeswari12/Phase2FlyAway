package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="Trip_Source_Destination")
public class TripSourceDestination {
	
@Id
/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Trip_generator")
@SequenceGenerator(name="Trip_generator", sequenceName = "Trip_SEQ", allocationSize=1)
*/
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int tripId;

private String sourceCityName;

private String sourceCountry;

private String destCityName;

private String destCountry;


//private FlightDetail flightDetail;

public int getTripId() {
	return tripId;
}

public void setTripId(int tripId) {
	this.tripId = tripId;
}

public String getSourceCityName() {
	return sourceCityName;
}

public void setSourceCityName(String sourceCityName) {
	this.sourceCityName = sourceCityName;
}

public String getSourceCountry() {
	return sourceCountry;
}

public void setSourceCountry(String sourceCountry) {
	this.sourceCountry = sourceCountry;
}

public String getDestCityName() {
	return destCityName;
}

public void setDestCityName(String destCityName) {
	this.destCityName = destCityName;
}

public String getDestCountry() {
	return destCountry;
}

public void setDestCountry(String destCountry) {
	this.destCountry = destCountry;
}

public TripSourceDestination() {
	super();
	// TODO Auto-generated constructor stub
}

public TripSourceDestination(String sourceCityName, String sourceCountry, String destCityName,
		String destCountry) {
	super();
	
	this.sourceCityName = sourceCityName;
	this.sourceCountry = sourceCountry;
	this.destCityName = destCityName;
	this.destCountry = destCountry;
}

@Override
public String toString() {
	return "TripSourceDestination [tripId=" + tripId + ", sourceCityName=" + sourceCityName + ", sourceCountry="
			+ sourceCountry + ", destCityName=" + destCityName + ", destCountry=" + destCountry + "]";
}



}
