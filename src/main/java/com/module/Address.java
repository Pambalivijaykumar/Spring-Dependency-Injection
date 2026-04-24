package com.module;

public class Address {
	
	String village;
	int zipCode;
	
	@Override
	public String toString() {
		return "Address [village=" + village + ", zipCode=" + zipCode + "]";
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Address(String village, int zipCode) {
		super();
		this.village = village;
		this.zipCode = zipCode;
	}

	public Address(){
		
	}

	public Address(String village) {
		super();
		this.village = village;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

}
