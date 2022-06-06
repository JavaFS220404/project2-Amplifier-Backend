package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PowerStats {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int intelligence;
	private int strength;
	private int speed;
	private int durability;
	private int power;
	private int combat;
	
	public PowerStats(int intelligence, int strength, int speed, int durability, int power, int combat) {
		super();
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
	}
	public PowerStats() {
		super();
	}
	public PowerStats(int id, int intelligence, int strength, int speed, int durability, int power, int combat) {
		super();
		this.id = id;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getCombat() {
		return combat;
	}
	public void setCombat(int combat) {
		this.combat = combat;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(combat, durability, intelligence, power, speed, strength);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerStats other = (PowerStats) obj;
		return combat == other.combat && durability == other.durability && intelligence == other.intelligence
				&& power == other.power && speed == other.speed && strength == other.strength;
	}

	@Override
	public String toString() {
		return "PowerStats [intelligence=" + intelligence + ", strength=" + strength + ", speed=" + speed
				+ ", durability=" + durability + ", power=" + power + ", combat=" + combat + "]";
	}
	
}
