package com.practicaljava.lesson6;

public class Contractor extends Person implements Payable {

	public Contractor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public boolean increasePay(int percent) {
		// TODO Auto-generated method stub
		if (percent < INCREASE_CAP) {
			System.out.println("Increasing salary by " + percent + "%. " + getName());
		} else {
			System.out.println("Sorry, can't increase hourly rate by more than " + INCREASE_CAP + " %." + getName());
		}
		return true;
	}

}
