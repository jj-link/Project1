package com.revature.service;

import com.revature.dao.IReimbursementDao;
import com.revature.dao.IUserDao;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementServiceTest {

    Date d = new Date(Instant.now().toEpochMilli());

    @Before
    public void setupBeforeMethods(){
        System.out.println("This runs once before each method in this class");
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    static IReimbursementDao rd;
    //We also have to use inject mocks, because UserService depends on UserDao
    @InjectMocks
    static ReimbursementService rs;

    @Test
    public void createReimbursementTest(){

        doNothing().when(rd).createReimbursement(any());

        rs.createReimbursement(100, d, "Hotel room", 1, 1, 3);

        verify(rd).createReimbursement(any());

    }

    @Test
    public void getAllPendingRequests(){

        List<Reimbursement> pendingList = new ArrayList<>();
        pendingList.add(new Reimbursement(100, d, "Hotel room", 1, 1, 3));

        when(rd.getAllPendingReimbursements()).thenReturn(pendingList);

        List<Reimbursement> returnedList = rs.getAllPendingRequests();

        assertEquals(pendingList, returnedList);

    }

    @Test
    public void getAllResolvedRequests(){

        List<Reimbursement> resolvedList = new ArrayList<>();
        resolvedList.add(new Reimbursement(100, d, "Hotel room", 1, 2, 3));

        when(rd.getAllResolvedReimbursements()).thenReturn(resolvedList);

        List<Reimbursement> returnedList = rs.getAllResolvedRequests();

        assertEquals(resolvedListList, returnedList);

    }

    @Test
    public void getAllReimbursementsByEmployee(){
        List<Reimbursement> employeeReimbursements = new ArrayList<>();

        when(rd.getAllReimbursementsByEmployee(any())).thenReturn(employeeReimbursements);

        List<Reimbursement> returnedList = rs.getAllReimbursementsByEmployee();

        assertEquals(employeeReimbursements, returnedList);
    }

    @Test
    public void updateReimbursementTest(){

        Reimbursement r = new Reimbursement(1000, d, "Bought a thing", 1, 1, 4);

        when(rd.updateReimbursement(any())).thenReturn(r);

        Reimbursement updatedReimbursement = rs.updateReimbursement(r);

        assertEquals(r, updatedReimbursement);

    }

    @Test
    public void resolveReimbursementTest(){
         
    }

}
