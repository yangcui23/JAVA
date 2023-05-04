package com;

public class Bat extends Mammal{
	protected int energy = 300;
	
	public void fly() {
		System.out.println(" Bat is flying!");
		energy -= 50;
		displayEnergy(energy);
	}
	
	public void eatHumans() {
		System.out.println(" Bat is eating humans!");
		energy += 25;
		displayEnergy(energy);
	}
	
	public void attackTown() {
		System.out.println(" Bat is attacking town!");
		energy -= 100;
		displayEnergy(energy);
	}
}
