package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        } else {
            return ResponseEntity.status(204).build();
        }
    }
    
    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("userName") String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        } else {
            return ResponseEntity.status(204).build();
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addOrUpdate(user);
        return ResponseEntity.status(201).build();
    }
    
	@PostMapping
	public ResponseEntity<User> loginAttempt(@RequestBody User user, HttpSession session){
		user = userService.login(user);
		if(user != null) {
			session.setAttribute("logged in", true);
			session.setAttribute("user", user);
			user.setPassword(null);
			return ResponseEntity.status(200).body(user);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
    
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.addOrUpdate(user);
        return ResponseEntity.status(202).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return ResponseEntity.status(202).build();
    }
}
