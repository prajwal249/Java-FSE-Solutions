package com.cognizant.loan_service.model;


public class Loan {

    private String loanNumber;
    private String loanType;
    private double loanAmount;


    public Loan() {

    }


    public String getLoanNumber() {
        return loanNumber;
    }


    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }


    public String getLoanType() {
        return loanType;
    }


    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }


    public double getLoanAmount() {
        return loanAmount;
    }


    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
}