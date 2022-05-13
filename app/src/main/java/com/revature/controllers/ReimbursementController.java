package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementCreator;
import com.revature.models.ReimbursementResolver;
import com.revature.services.ReimbursementService;
import io.javalin.http.Handler;

public class ReimbursementController {

    private ReimbursementService rServ;
    private ObjectMapper om;

    public ReimbursementController(ReimbursementService rServ){
        this.rServ = rServ;
        this.om = new ObjectMapper();
    }

    public Handler handleCreateRequest = (ctx) -> {

        ReimbursementCreator rc = om.readValue(ctx.body(), ReimbursementCreator.class);
        int author_id = (int) ctx.req.getSession().getAttribute("user_id");

        if(ctx.req.getSession().getAttribute("role_id") == null){
            ctx.status(403);
            ctx.result("Must be logged in to create request");
        }
        else if(rc.getAmount() <= 0){
            ctx.status(409);
            ctx.result("amount must be > 0");
        }
        else {
            rServ.createReimbursement(rc, author_id);
            ctx.status(201);
            ctx.result("Reimbursement request successfully created");
        }

    };

    public Handler handleResolveRequest = (ctx) -> {

        ReimbursementResolver rr = om.readValue(ctx.body(), ReimbursementResolver.class);

        if((ctx.req.getSession().getAttribute("role_id") == null) ||
                (ctx.req.getSession().getAttribute("role_id").equals(2))) {

            ctx.status(403);
            ctx.result("Must be logged in as Manager to resolve reimbursement request");
        } else if (ctx.req.getSession().getAttribute("role_id").equals(1)){

        }

    };


}
