package com.javaLesson13.tryit1;

public class LambdaTask {
    static String section,domain;
	public static void main(String[] args) {
		Zoo bird = (int age) -> {
			
			if (age > 10) {
				section = "A";

			} else {
				section = "B";

			}
			return section;
		};

		Zoo fish = (int age) -> {
			

			if (age > 2) {
				domain = "Acquamarine";
			}
			return domain;

		};

		Animal animal1 = new Animal();
		animal1.name = " Blue bird";
		animal1.age = 11;
		animal1.animalId(bird);

		Animal animal2 = new Animal();
		animal2.name = " Green Bird";
		animal2.age = 5;
		animal2.animalId(bird);

		Animal animal3 = new Animal();
		animal3.name = " Yellow fish";
		animal3.age = 2;
		animal3.animalId(fish);
	}

}
