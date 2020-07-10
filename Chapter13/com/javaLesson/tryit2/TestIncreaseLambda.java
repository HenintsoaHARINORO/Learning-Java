package com.javaLesson.tryit2;

public class TestIncreaseLambda {
	public static void main(String[] args) {
		Person workers[] = new Person[4];
		workers[0] = new Person("John", 'E');
		workers[1] = new Person("Mary", 'C');
		workers[2] = new Person("Steve", 'E');
		workers[3] = new Person("Jack", 'F');

		Payable increaseRulesEmployee = (int percent) -> {
			return true;
		};

		Payable increaseRulesContractor = (int percent) -> {
			if (percent > Payable.INCREASE_CAP) {
				System.out.print(" Sorry, can't increase hourly rate by more than " + Payable.INCREASE_CAP + "%. ");
				return false;
			} else {
				return true;
			}
		};

		Payable increaseRulesForeigner = (int percent) -> {
			if (percent > Payable.INCREASE_CAP) {
				System.out.print(" Sorry, can't increase hourly rate by more than " + Payable.INCREASE_CAP + "%. ");
				return false;
			} else {
				return true;
			}
		};

		for (Person p : workers) {
			if ('E' == p.getWorkerStatus()) {

				p.validatePayIncrease(increaseRulesEmployee, 30);
			} else if ('C' == p.getWorkerStatus()) {
				p.validatePayIncrease(increaseRulesContractor, 30);
			} else if ('F' == p.getWorkerStatus()) {
				p.validatePayIncrease(increaseRulesForeigner, 10);
			}
		}
	}
}
