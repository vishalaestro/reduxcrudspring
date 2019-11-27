package com.reduxcrud.reduxcrud;

public class Address {
	public Address(String primaryAddress, String secondaryAddress) {
		super();
		this.primaryAddress = primaryAddress;
		this.secondaryAddress = secondaryAddress;
	}
	private String primaryAddress;
	private String secondaryAddress;
	public String getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	public String getSecondaryAddress() {
		return secondaryAddress;
	}
	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}
}
