package com.cognizant.loan_service.service;


import org.springframework.stereotype.Service;

import com.cognizant.loan_service.model.Loan;


@Service
public class LoanService {


    public Loan getLoan(String loanNumber) {

        Loan loan = new Loan();

        loan.setLoanNumber(loanNumber);
        loan.setLoanType("Home Loan");
        loan.setLoanAmount(250000);

        return loan;
    }
}