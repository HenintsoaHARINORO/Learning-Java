package com.javaLesson13.tryit1;

public class Animal {
	String name;
	int age;

	public void animalId(Zoo anyBird) {
		String sec = anyBird.animalId(age);
		System.out.println("My name is" + name + " I am " + age + " years old");
		System.out.println("I am in section " + sec);

	}
}
