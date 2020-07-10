package com.javalesson12.tryit;

public class RetiredEmployee  extends Employee{
	

	private double pensionAmount;

	public RetiredEmployee(String name, double pensionAmount) {
		super(name);
		this.pensionAmount= pensionAmount;
		
		
	}

}
