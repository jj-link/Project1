package com.revature.services;

import com.revature.dao.IUserDao;
import com.revature.exceptions.LoginInfoIncorrectException;
import com.revature.models.User;

public class UserService {

    private IUserDao ud;

    public UserService(IUserDao uDao) {
        this.ud = uDao;
    }

    public void registerUser(String username, String firstName, String lastName, String email, String password, int role_id){
        User register = new User(username, firstName, lastName, email, password, role_id);
        ud.createUser(register);
    }

    public User loginUser(String emailOrUsername, String password) throws LoginInfoIncorrectException {
        User u = ud.getUserByEmailOrUsername(emailOrUsername);

        if (u == null || !password.equals(u.getPassword())) {
            //LoggingUtil.logger.warn("User login attempt failed");
            throw new LoginInfoIncorrectException();
        } else {
            //LoggingUtil.logger.info("User " + u.getUsername() + " was logged in");
            return u;
        }
    }

    public User updateUserInfo(User u){
        return ud.updateUser(u);
    }

    public void deleteUser(String usernameOrEmail){
        ud.deleteUserByEmailOrUsername(usernameOrEmail);
    }

}
