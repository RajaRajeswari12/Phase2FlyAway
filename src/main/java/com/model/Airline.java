package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Airline")
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Airline_Generator")
	@SequenceGenerator(name="Airline_Generator",sequenceName="Airline_Seq",initialValue=2,allocationSize=1)*/
	private int airlineId;
	
	@Column(unique=true)
	private String airLineName;

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airLineName=" + airLineName + "]";
	}
	
	
}
