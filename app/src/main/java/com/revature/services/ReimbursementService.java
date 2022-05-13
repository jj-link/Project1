package com.revature.services;

import com.revature.dao.IReimbursementDao;
import com.revature.exceptions.InvalidAmountException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementResolver;

import java.sql.Date;
import java.util.List;

public class ReimbursementService {

    private IReimbursementDao rd;

    public ReimbursementService(IReimbursementDao rd) {this.rd=rd;}

    public void createReimbursement(double amount, Date submittedDate, String Description, int reimbursementAuthor,
                                    int reimbursementStatus, int reimbursementType) throws InvalidAmountException {

        Reimbursement r = new Reimbursement(amount, submittedDate, Description, reimbursementAuthor, reimbursementStatus, reimbursementType);
        if(amount <= 0){
            throw new InvalidAmountException();
        } else{
            rd.createReimbursement(r);
        }
    }

    public List<Reimbursement> getAllPendingRequests(){
        return rd.getAllPendingReimbursements();
    }

    public List<Reimbursement> getAllResolvedRequests(){
        return rd.getAllResolvedReimbursements();
    }

    public List<Reimbursement> getAllReimbursementsByEmployee(int userId){
        return rd.getAllReimbursementsByEmployee(userId);
    }

    public Reimbursement updateReimbursement(Reimbursement r){
        return rd.updateReimbursement(r);
    }

    public void resolveReimbursement(ReimbursementResolver rr){
        rd.resolveReimbursement(rr);
    }

    public void deleteReimbursement(int reimbursementId){
        rd.deleteReimbursement(reimbursementId);
    }

}
