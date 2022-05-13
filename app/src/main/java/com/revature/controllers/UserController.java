package com.revature.controllers;

import com.revature.models.LoginObject;
import com.revature.models.User;
import com.revature.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.util.List;

public class UserController {

    private UserService uServ;
    private ObjectMapper om;
    public UserController(UserService uServ){
        this.uServ=uServ;
        this.om = new ObjectMapper();
    }


    public Handler handleRegister = (ctx) -> {
        User u = om.readValue(ctx.body(), User.class);

        //check to see if username or email is already taken
        boolean isTaken = false;
        for (User currentUser: uServ.getAllUsers()){
            //System.out.println("inside user loop");
            if((u.getUsername().equals(currentUser.getUsername())) || (u.getEmail().equals(currentUser.getEmail()))){
                isTaken = true;
            }
        }
        if(isTaken == false){
            uServ.registerUser(u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(), u.getRole_id());
            ctx.status(201);
        }else{
            ctx.status(409);
            ctx.result("Username or email already taken");
        }
    };

    public Handler handleLogin = (ctx) -> {
        LoginObject lo = om.readValue(ctx.body(), LoginObject.class);
        User u = uServ.loginUser(lo);

        if(u==null){
            ctx.status(403);
            ctx.result("Email or password incorrect");
        } else {
            //logged in successfully, set up session
            ctx.req.getSession().setAttribute("user_id", u.getUser_id());
            ctx.req.getSession().setAttribute("username", u.getUsername());
            ctx.req.getSession().setAttribute("role_id", u.getRole_id());
            ctx.status(200);
            ctx.result("User logged in successfully");
        }
    };

    public Handler handleLogout = (ctx) ->{
        ctx.req.getSession().setAttribute("user_id", null);
        ctx.req.getSession().setAttribute("username", null);
        ctx.req.getSession().setAttribute("role_id", null);
        ctx.status(205);
        ctx.result("User has successfully logged out");
    };

    public Handler handleGetAllUsers = (ctx) ->{

        List<User> userList = uServ.getAllUsers();
        if((ctx.req.getSession().getAttribute("role_id") == null) ||
                (ctx.req.getSession().getAttribute("role_id").equals(2))) {

            ctx.status(403);
            ctx.result("Must be logged in as Manager to view all accounts");
        } else if (ctx.req.getSession().getAttribute("role_id").equals(1)){

            List<User> allUsers = uServ.getAllUsers();
            ctx.status(200);
            ctx.result("" + userList);
        } else{
            ctx.status(404);
            ctx.result("You did something weird");
        }
    };

    public Handler handleUpdateUser = (ctx) ->{
        User u = om.readValue(ctx.body(), User.class);
        if(ctx.req.getSession().getAttribute("username").equals(u.getUsername())){
            u = uServ.updateUserInfo(u);
            ctx.status(200);
            ctx.result("User info updated successfully");
        } else {
            ctx.status(401);
            ctx.result("You must be logged in as the correct user to update user info");
        }
    };
    
}