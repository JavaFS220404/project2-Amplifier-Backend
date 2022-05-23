package com.revature.daos;

import com.revature.models.User;

public interface UserDAO {
	
	public User getByUserName(String username);
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user); 


}
