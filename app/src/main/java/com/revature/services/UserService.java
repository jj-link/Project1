package com.revature.services;

import com.revature.dao.IUserDao;
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

}
