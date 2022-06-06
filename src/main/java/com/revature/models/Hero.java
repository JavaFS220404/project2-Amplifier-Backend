package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="characters")
public class Hero {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator ="hero_seq_gen")
	@SequenceGenerator(name = "hero_seq_gen", initialValue = 901)
	private int id;
	private String name;
	private int intelligence;
	private int strength;
	private int speed;
	private int durability;
	private int power;
	private int combat;
	@ManyToOne
	@JsonBackReference
	private User creator;
	private boolean isPublic;
	
	public Hero(int id, String name, int intelligence, int strength, int speed, int durability, int power, int combat,
			User creator, boolean isPublic) {
		super();
		this.id = id;
		this.name = name;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.creator = creator;
		this.isPublic = isPublic;
	}
	public Hero() {
		super();
	}
	public Hero(String name, int intelligence, int strength, int speed, int durability, int power, int combat,
			User creator, boolean isPublic) {
		super();
		this.name = name;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.creator = creator;
		this.isPublic = isPublic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	@Override
	public int hashCode() {
		return Objects.hash(combat, creator, durability, id, intelligence, isPublic, name, power, speed, strength);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		return combat == other.combat && Objects.equals(creator, other.creator) && durability == other.durability
				&& id == other.id && intelligence == other.intelligence && isPublic == other.isPublic
				&& Objects.equals(name, other.name) && power == other.power && speed == other.speed
				&& strength == other.strength;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", intelligence=" + intelligence + ", strength=" + strength
				+ ", speed=" + speed + ", durability=" + durability + ", power=" + power + ", combat=" + combat
				+ ", creator=" + creator + ", isPublic=" + isPublic + "]";
	}
	
}
