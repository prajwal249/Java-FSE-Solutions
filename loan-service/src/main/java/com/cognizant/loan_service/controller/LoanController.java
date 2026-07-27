package com.cognizant.loan_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.loan_service.model.Loan;
import com.cognizant.loan_service.service.LoanService;


@RestController
@RequestMapping("/loans")
public class LoanController {


    @Autowired
    private LoanService loanService;


    @GetMapping("/{loanNumber}")
    public Loan getLoan(
            @PathVariable String loanNumber) {

        return loanService.getLoan(loanNumber);
    }
}