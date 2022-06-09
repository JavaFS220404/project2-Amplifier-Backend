package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {
    protected UserDAO userDao;
    @Autowired
    public UserService(UserDAO userDao) {
        super();
        this.userDao=userDao;
    }
    public List<User> getAllUser(){
        return userDao.findAll();
    }
    
    public User getUserById(int id) {
        Optional<User> opt = userDao.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
    
    public User getUserByUsername(String username) {
        Optional<User> opt = userDao.findByUsername(username);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
    
    public User addOrUpdate(User user) {
        User dbUser = userDao.save(user);
        return dbUser;

    }
    public User Update(int userId, int heroId) {
    	
    	 Optional<User> opt = userDao.findById(userId);
    	 
         if(opt.isPresent()) {
        	 User dbUser = opt.get();
        	 String newList = dbUser.getFavouriteCharacters();
        	 if (newList==null) {
        		 newList = String.valueOf(heroId);
        	 }else {
        		 newList = newList + "," + heroId;
        	 }
        	 dbUser.setFavouriteCharacters(newList);
        	 userDao.save(dbUser);
        	 return dbUser;
         }	
         
         return null;
         

    }
    
    public User login(User attempt) {
		Optional<User> opt = userDao.findByUsername(attempt.getUsername());
		if(opt.isPresent()) {
			User dbUser = opt.get();
			if(dbUser.getPassword().equals(attempt.getPassword())) {
				return dbUser;
			}
		}
		return null;
	}
    
    public void deleteUser(int id) {
        User user = getUserById(id);
        userDao.delete(user);
    }
}