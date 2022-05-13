package com.revature.services;

import com.revature.dao.IReimbursementDao;
import com.revature.exceptions.InvalidAmountException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementCreator;
import com.revature.models.ReimbursementResolver;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ReimbursementService {

    private IReimbursementDao rd;

    public ReimbursementService(IReimbursementDao rd) {this.rd=rd;}

    public void createReimbursement(ReimbursementCreator rc, int reimbursementAuthor) throws InvalidAmountException {
        Date d = new Date(Instant.now().toEpochMilli());

        Reimbursement r = new Reimbursement(rc.getAmount(), d, rc.getDescription(), reimbursementAuthor, 1, rc.getReimbursementType());
        if(rc.getAmount() <= 0){
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
