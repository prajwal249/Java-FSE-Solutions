package com.cognizant.account_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.account_service.model.Account;
import com.cognizant.account_service.service.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {


    @Autowired
    private AccountService accountService;


    @GetMapping("/{accountNumber}")
    public Account getAccount(
            @PathVariable String accountNumber) {

        return accountService.getAccount(accountNumber);
    }

}