package com.revature.service;

import com.revature.dao.IUserDao;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    static IUserDao ud;

    //We also have to use inject mocks, because UserService depends on UserDao
    @InjectMocks
    static UserService us;

    //Lets first test UserServer.requestUser
    @Test
    public void registerCreatesNewUser(){

        //When the dao is supposed to return a value, we can overide the actual functionality
        //And just return whatever we want

        doNothing().when(ud.createUser(any()));
        //Now we have overriden the dao funcationality, we call the actual method we are testing
        us.registerUser("myusername", "firstName", "lastName", "email@email.com", "passwword", 2);


        //Since this doesn't return anything, it just calls the dao to save to the db, we want to be sure
        //The dao method was called successfully

        //Verify that the user service called UserDao.createUser()
        verify(ud).createUser(any());

    }
/*
    //Lets test a positive login case
    @Test
    public void validLoginCredentialsTest() throws UsernameOrPasswordIncorrectException {
        User u = new User("User", "Test", "test", "test@mail.com", "password");

        //When our dao method gets called, instead of searching the database for a user, we will
        //return the precreated used above
        when(ud.getUserByUsername(any())).thenReturn(u);


        User loggedIn = us.loginUser("test", "password");
        verify(ud).getUserByUsername(any());

        //AssertEquals takes in three values
        //Messsage, Expected, Actual
        assertEquals("The first name should be User", "User", loggedIn.getFirst());
        //Then we could write more assertEquals for each of our user properties of our User
    }

    @Test(expected=UsernameOrPasswordIncorrectException.class)
    public void wrongUsernameTest() throws UsernameOrPasswordIncorrectException{
        User u = null;

        when(ud.getUserByUsername(any())).thenReturn(u);

        User loggedIn = us.loginUser("test", "password");
    }

    @Test(expected=UsernameOrPasswordIncorrectException.class)
    public void wrongPasswordTest() throws UsernameOrPasswordIncorrectException {
        User u = new User("User", "Test", "test", "test@mail.com", "password");

        when(ud.getUserByUsername(any())).thenReturn(u);

        User loggedIn = us.loginUser("test", "pass");
    }

}



 */

}
