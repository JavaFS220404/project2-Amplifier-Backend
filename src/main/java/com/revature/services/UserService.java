package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {
    private UserDAO userDao;
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
    
    public User getUserByUserName(String userName) {
        Optional<User> opt = userDao.findByUserName(userName);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
    
    public User addOrUpdate(User user) {
        User dbUser = userDao.save(user);
        return dbUser;

    }
    
    public void deleteUser(int id) {
        User user = getUserById(id);
        userDao.delete(user);
    }
}