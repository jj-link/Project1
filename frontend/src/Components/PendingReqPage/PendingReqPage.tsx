import React, { useEffect } from 'react';
import './PendingReqPage.css';

import { IReimbursement } from '../../interfaces/IReimbursement';

import { Link } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';

import { RootState, AppDispatch } from '../../store';
import { getAllPendingByUser } from '../../slices/ReimbursementSlice';

import { Navbar } from '../Navbar/Navbar';

// go inside App for routing
export const PendingReqPage: React.FC<any> = () => {
  const pendingInfo = useSelector(
    (state: RootState) => state.reimbursement.allPending
  );

  // let reversePending = pendingInfo?.reverse();
  const userInfo = useSelector((state: RootState) => state.user.user);

  const dispatch: AppDispatch = useDispatch();

  useEffect(() => {}, [pendingInfo]);

  return (
    <>
      <Navbar />
      <div className="pendingWrapper">
        <div className="pendingDetails">
          <p>{userInfo?.role}</p>
          <p>{userInfo?.firstName}</p>
        </div>

        {/* <div className="pendingHeader">
          <h3>All Pending Requests</h3>
        </div> */}

        {pendingInfo?.length! <= 0 ? (
          <h3 className="pendingHeader">
            {userInfo?.firstName}, it seems like all your requests have been
            resolved.
          </h3>
        ) : (
          pendingInfo?.map((info) => {
            return (
              <div
                key={info.id}
                className="pendingColumn"
                style={{ color: 'white' }}
              >
                {/* <h3>{info.reimbursementStatus}</h3> */}
                <p>Amount: ${info.amount}</p>
                <p>Description: {info.description}</p>
                <p>Type: {info.reimbursementType}</p>
              </div>
            );
          })
        )}

        <div className="pendingButtons">
          <Link to="/home">
            <button>Back</button>
          </Link>
          <Link to="/resolvedrequest">
            <button>Check Resolved</button>
          </Link>
        </div>
      </div>
    </>
  );
};
