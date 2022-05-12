/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.revature;

import com.revature.dao.*;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

public class Driver {

    private static final IUserDao uDao = new UserDaoJDBC();
    private static final IReimbursementDao rDao = new ReimbursementDaoJDBC();


    public static void main(String[] args) {

        User FinanceManager = new User("jj_link", "Joseph", "Link", "jj_link@email.com", "password", 1);
        uDao.createUser(FinanceManager);

        /*
        User createEmployee = new User("j_doe", "John", "Doe", "jdoe@email.com", "pa$$word", 2);
        uDao.createUser(createEmployee);

         */

        User fm = uDao.getUserByEmailOrUsername("jj_link");
        System.out.println("Testing get user by userNameorEmail:  " + fm.toString());

        System.out.println("Testing Get all users:  " + uDao.getAllUsers());

        //uDao.deleteUserByEmailOrUsername("jj_link@email.com");
        //System.out.print(uDao.getAllUsers());

        User updatedUser = new User(fm.getUser_id(), fm.getUsername(), "Broseph", fm.getLastName(), fm.getEmail(), fm.getPassword(), fm.getRole_id());
        uDao.updateUser(updatedUser);
        System.out.println("Printing updated user: " + updatedUser.toString());


        //test create reimbursements
        Date d = new Date(Instant.now().toEpochMilli());
        Reimbursement r1 = new Reimbursement(1000, d, "bought an Xbox", 1, 1, 4);
        rDao.createReimbursement(r1);

        d = new Date(Instant.now().toEpochMilli());
        Reimbursement r2 = new Reimbursement(1000, d, "bought a Laptop", 2, 1, 4);
        rDao.createReimbursement(r2);



        //test read methods

        //test get all pending requests
        List<Reimbursement> pendingList = new ArrayList<>();
        pendingList = rDao.getAllPendingReimbursements();
        System.out.println("List of all pending requests: " + pendingList);

        //test get all resolved requests
        List<Reimbursement> resolvedList = new ArrayList<>();
        resolvedList = rDao.getAllResolvedReimbursements();
        System.out.println("List of all resolved requests: " + resolvedList);

        //test get reimbursements by employee
        List<Reimbursement> rList = rDao.getAllReimbursementsByEmployee(1);
        System.out.println("List of all Reimbursements by employee 1: " + rList);


        //test update reimbursement
        d = new Date(Instant.now().toEpochMilli());
        Reimbursement updatedReimbursement = new Reimbursement(1000, d, "Bought some Yeezys", 1, 1, 4);
        updatedReimbursement.setId(1);
        rDao.updateReimbursement(updatedReimbursement);


        //test resolve reimbursement
        rDao.resolveReimbursement(2,1,3);

        //test get all resolved requests
        resolvedList = new ArrayList<>();
        resolvedList = rDao.getAllResolvedReimbursements();
        System.out.println("List of all resolved requests: " + resolvedList);

        //test delete reimbursement
        rDao.deleteReimbursement(1);

    }
}
