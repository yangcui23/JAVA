package com;

public class Gorilla extends Mammal {
	
	
	public void throwSomething() {
		System.out.println("The gorilla has throw something somewhere");
		energy = energy - 5;
		displayEnergy(energy);
	}
	
	public void eatBananas() {
		System.out.println("The gorilla has eat some bananas");
		energy = energy + 10;
		displayEnergy(energy);
		
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a TREE");
		energy = energy - 10;
		displayEnergy(energy);
	}
}
