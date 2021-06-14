package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightrunningdays")
public class FlightRunningDays {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightScheduleId;
	
	/*
	 * @OneToOne(targetEntity = FlightDetail.class,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn( name="flightId",nullable=false) private FlightDetail
	 * flightdetail;
	 */
	
	@Column(name="Monday")
	private boolean runningOnMonday;
	
	@Column(name="Tuesday")
	private boolean runningOnTuesday;
	
	@Column(name="Wednesday")
	private boolean runningOnWednesday;
	
	@Column(name="Thursday")
	private boolean runningOnThursday;
	
	@Column(name="Friday")
	private boolean runningOnFriday;
	
	@Column(name="Saturday")
	private boolean runningOnSaturday;
	
	@Column(name="Sunday")
	private boolean runningOnSunday;

	public FlightRunningDays() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}
	 
	/*
	 * public FlightDetail getFlightdetail() { return flightdetail; }
	 * 
	 * public void setFlightdetail(FlightDetail flightdetail) { this.flightdetail =
	 * flightdetail; }
	 */
	public boolean isRunningOnMonday() {
		return runningOnMonday;
	}

	public void setRunningOnMonday(boolean runningOnMonday) {
		this.runningOnMonday = runningOnMonday;
	}

	public boolean isRunningOnTuesday() {
		return runningOnTuesday;
	}

	public void setRunningOnTuesday(boolean runningOnTuesday) {
		this.runningOnTuesday = runningOnTuesday;
	}

	public boolean isRunningOnWednesday() {
		return runningOnWednesday;
	}

	public void setRunningOnWednesday(boolean runningOnWednesday) {
		this.runningOnWednesday = runningOnWednesday;
	}

	public boolean isRunningOnThursday() {
		return runningOnThursday;
	}

	public void setRunningOnThursday(boolean runningOnThursday) {
		this.runningOnThursday = runningOnThursday;
	}

	public boolean isRunningOnFriday() {
		return runningOnFriday;
	}

	public void setRunningOnFriday(boolean runningOnFriday) {
		this.runningOnFriday = runningOnFriday;
	}

	public boolean isRunningOnSaturday() {
		return runningOnSaturday;
	}

	public void setRunningOnSaturday(boolean runningOnSaturday) {
		this.runningOnSaturday = runningOnSaturday;
	}

	public boolean isRunningOnSunday() {
		return runningOnSunday;
	}

	public void setRunningOnSunday(boolean runningOnSunday) {
		this.runningOnSunday = runningOnSunday;
	}

	public FlightRunningDays(int flightScheduleId, FlightDetail flightdetail, boolean runningOnMonday,
			boolean runningOnTuesday, boolean runningOnWednesday, boolean runningOnThursday, boolean runningOnFriday,
			boolean runningOnSaturday, boolean runningOnSunday) {
		super();
		this.flightScheduleId = flightScheduleId;
//		this.flightdetail = flightdetail;
		this.runningOnMonday = runningOnMonday;
		this.runningOnTuesday = runningOnTuesday;
		this.runningOnWednesday = runningOnWednesday;
		this.runningOnThursday = runningOnThursday;
		this.runningOnFriday = runningOnFriday;
		this.runningOnSaturday = runningOnSaturday;
		this.runningOnSunday = runningOnSunday;
	}

	@Override
	public String toString() {
		return "FlightRunningDays [flightScheduleId=" + flightScheduleId +  ", runningOnMonday=" + runningOnMonday + ", runningOnTuesday=" + runningOnTuesday
				+ ", runningOnWednesday=" + runningOnWednesday + ", runningOnThursday=" + runningOnThursday
				+ ", runningOnFriday=" + runningOnFriday + ", runningOnSaturday=" + runningOnSaturday
				+ ", runningOnSunday=" + runningOnSunday + "]";
	}


	

	


}
