package com.klef.jfsd.exam;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Tablet extends Device{
	double screensize;
	String battery;
	public double getScreensize() {
		return screensize;
	}
	public void setScreensize(double screensize) {
		this.screensize = screensize;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	
}
