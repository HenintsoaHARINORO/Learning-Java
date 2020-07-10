package com.javalesson12.tryit;

import java.util.LinkedList;
import java.util.List;

public class TestGenericMethod {

	public static void main(String[] args) {
		List<RetiredEmployee> retiredEmployees = new LinkedList<>();

		RetiredEmployee retiredEmployee1 = new RetiredEmployee("Alan Smith", 50000);
		RetiredEmployee retiredEmployee2 = new RetiredEmployee("Mary", 600000);
		RetiredEmployee retiredEmployee3 = new RetiredEmployee("Alan Smith", 70000);

		retiredEmployees.add(retiredEmployee1);
		retiredEmployees.add(retiredEmployee2);
		retiredEmployees.add(retiredEmployee3);

		List<Employee> employees = new LinkedList<>();

		copyEmployees(retiredEmployees, employees);
		System.out.println("Copied employees: ");
		for (Employee e : employees) {
			System.out.println(e.getName());
		}

	}

	public static void copyEmployees(List<? extends Employee> from, List<Employee> to) {
		for (Employee e : from) {
			to.add(new Employee(e.getName()));
		}

	}

}
