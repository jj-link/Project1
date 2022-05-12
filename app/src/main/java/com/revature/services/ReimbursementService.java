package com.revature.services;

import com.revature.dao.IReimbursementDao;
import com.revature.models.Reimbursement;

import java.sql.Date;

public class ReimbursementService {

    private IReimbursementDao rd;

    public ReimbursementService(IReimbursementDao rd) {this.rd=rd;}

    public void createReimbursement(double amount, Date submittedDate, String Description, int reimbursementAuthor,
                                    int reimbursementStatus, int reimbursementType) {

        Reimbursement r = new Reimbursement(amount, submittedDate, Description, reimbursementAuthor, reimbursementStatus, reimbursementType);

        rd.createReimbursement(r);
    }



}
