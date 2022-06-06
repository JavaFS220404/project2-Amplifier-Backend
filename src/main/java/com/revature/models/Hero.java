package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="characters")
public class Hero {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private PowerStats powerStats;
	@ManyToOne
	@JsonBackReference
	private User creator;
	private boolean isPublic;
	
	public Hero() {
		super();
	}

	Hero(int id, String name, PowerStats powerStats, User creator, boolean isPublic) {
		this.id = id;
		this.name = name;
		this.powerStats = powerStats;
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
	public PowerStats getPowerStats() {
		return powerStats;
	}
	public void setPowerStats(PowerStats powerStats) {
		this.powerStats = powerStats;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(creator, id, isPublic, name);
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
		return Objects.equals(creator, other.creator) && id == other.id && isPublic == other.isPublic
				&& Objects.equals(name, other.name) && Objects.equals(powerStats, other.powerStats);
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", powerStats=" + powerStats +  ", creator=" + creator
				+ ", isPublic=" + isPublic + "]";
	}
}
