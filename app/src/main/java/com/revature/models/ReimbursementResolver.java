package com.revature.models;

public class ReimbursementResolver {
    private int reimbursementId;
    private int resolverId;
    private int status;

    public ReimbursementResolver() {
    }

    public ReimbursementResolver(int reimbursementId, int resolverId, int status) {
        this.reimbursementId = reimbursementId;
        this.resolverId = resolverId;
        this.status = status;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReimbursementResolver{" +
                "reimbursementId=" + reimbursementId +
                ", resolverId=" + resolverId +
                ", status=" + status +
                '}';
    }
}
