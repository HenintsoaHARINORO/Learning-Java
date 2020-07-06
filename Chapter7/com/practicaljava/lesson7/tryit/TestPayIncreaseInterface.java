package com.practicaljava.lesson7.tryit;

public class TestPayIncreaseInterface {
	public static void main(String[] args) {
		Payable workers[] = new Payable[3];
		workers[0] = (Payable) new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = (Payable) new Employee("Steve");
		for (Payable p : workers) {
			((Payable) p).increasePay(30);
		}
	}
}
