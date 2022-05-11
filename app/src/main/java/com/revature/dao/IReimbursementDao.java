package com.revature.dao;

import com.revature.models.Reimbursement;

import java.util.List;

public interface IReimbursementDao {

    //create
    void createReimbursement(Reimbursement r);

    //read
    List<Reimbursement> getAllPendingReimbursements();
    List<Reimbursement> getAllResolvedReimbursements();
    List<Reimbursement> getAllReimbursementsByEmployee(int userId);

    //update
    Reimbursement update_Reimbursement(Reimbursement r);
    void resolveReimbursement(int reimbursementId, int resolverId, int newStatus);

    //delete
    void deleteReimbursement(int reimbursementId);
}
