package com.revature.models;

public class Reimbursement_status {

    private int id;
    private String status;

    public Reimbursement_status() {
    }

    public Reimbursement_status(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement_status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
