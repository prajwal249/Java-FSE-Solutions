package com.cognizant.account_service.service;

import org.springframework.stereotype.Service;
import com.cognizant.account_service.model.Account;


@Service
public class AccountService {


    public Account getAccount(String accountNumber) {

        return new Account(
                accountNumber,
                "Savings",
                50000
        );
    }
}