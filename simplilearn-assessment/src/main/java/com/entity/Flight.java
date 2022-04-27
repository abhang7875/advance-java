package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id @GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="Airlines",length=20)
	private String airlines;
	@Column(name="From_City",length=20)
	private String from;
	@Column(name="To_City",length=20)
	private String to;
	@Column(name="DepartOn",length=20)
	private String departOn;
	@Column(name="ArriveOn",length=20)
	private String arriveOn;
	@Column(name="Available_Seats",length=20)
	private int numberOfSeatsAvailable;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDepartOn() {
		return departOn;
	}
	public void setDepartOn(String departOn) {
		this.departOn = departOn;
	}
	public String getArriveOn() {
		return arriveOn;
	}
	public void setArriveOn(String arriveOn) {
		this.arriveOn = arriveOn;
	}
	public int getNumberOfSeatsAvailable() {
		return numberOfSeatsAvailable;
	}
	public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", airlines=" + airlines + ", from=" + from + ", to=" + to + ", departOn="
				+ departOn + ", arriveOn=" + arriveOn + ", numberOfSeatsAvailable=" + numberOfSeatsAvailable + "]";
	}
	
}
