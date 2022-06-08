package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserServiceTest {
	
	private static UserService userService;
	private static UserDAO userDAO;
	
	private User testUser;
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
        userService = new UserService(userDAO);
        userDAO = mock(UserDAO.class);
        userService.userDao = userDAO;
    }
	
	@Before
    public void setUp() throws Exception {
		testUser = new User("TestUser", "TestPassword");
    }
	
	@Test
    public void testGetByUsernamePassesWhenUsernameExists() {
        when(userDAO.findByUsername(anyString())).thenReturn(Optional.of(testUser));

        assertEquals(Optional.of(testUser), userService.getUserByUsername(testUser.getUsername()));

        verify(userDAO).findByUsername(testUser.getUsername());
    }
}
