package com.revature.models;

public class Reimbursement_type {

    private int id;
    private String type;

    public Reimbursement_type() {
    }

    public Reimbursement_type(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement_type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
