package com.revature.models;

public class User extends AbstractUser {

	private String firstname;
	private String lastname;
	private String email;

	public User() {
		super();
	}

	
	public User(int id, String username, String password, Role role) {
		super(id, username, password, role);
	}
	
	public User(int id, String username, String password, Role role, String firstname, String lastname, String email ) {
		super(id, username, password, role);
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
