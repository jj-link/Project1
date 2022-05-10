package com.revature.models;

public class User_role {

    private int id;
    private String role;

    public User_role() {
    }

    public User_role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User_role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
