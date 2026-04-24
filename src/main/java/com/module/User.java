package com.module;

public class User {
	
	String name;
	int id;
	
	Address address;
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String name, int id, Address address) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
	}


	public User() {
		
	}
	

	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", address=" + address + "]";
	}

}
