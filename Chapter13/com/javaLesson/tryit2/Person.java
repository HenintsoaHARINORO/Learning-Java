package com.javaLesson.tryit2;

public class Person {
	String name;
	char workerStatus;

	Person(String name, char c) {
		this.name = name;
		this.workerStatus = c;
	}

	public String getName() {
		return name;
	}

	public char getWorkerStatus() {
		return workerStatus;
	}

	public boolean validatePayIncrease(Payable increaseFunction, int percent) {
		boolean isIncreaseValid = increaseFunction.increasePay(percent);
		System.out.println(" Increasing pay for " + name + " is " + (isIncreaseValid ? "valid." : "not valid."));
		return isIncreaseValid;
	}
}
