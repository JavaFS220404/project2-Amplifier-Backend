package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity

public class User {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	@ManyToMany
	@JoinColumn(name="characterId")
	private List<Hero> favouriteCharacters;

	public User() {
		super();
	}
	

	public User(int id, String firstName, String lastName, String email, String username, String password,
			List<Hero> favouriteCharacters) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.favouriteCharacters = favouriteCharacters;
	}
	


	@Override
	public String toString() {
		return "User [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id, email, firstName, lastName, password, username);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Hero> getFavouriteCharacters() {
		return favouriteCharacters;
	}

	public void setFavouriteCharacters(List<Hero> favouriteCharacters) {
		this.favouriteCharacters = favouriteCharacters;
	}
	


}
