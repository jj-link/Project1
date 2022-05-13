package com.revature.models;

public class ReimbursementResolver {

    private int resolverId;
    private int reimbursementId;
    private int status;

    public ReimbursementResolver() {
    }

    public ReimbursementResolver(int resolverId, int reimbursementId, int status) {
        this.resolverId = resolverId;
        this.reimbursementId = reimbursementId;
        this.status = status;
    }


    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    @Override
    public String toString() {
        return "ReimbursementResolver{" +
                "resolverId=" + resolverId +
                ", reimbursementId=" + reimbursementId +
                ", status=" + status +
                '}';
    }
}
