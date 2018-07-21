package com.mycompany.onlinebankwebserviceapi.model;

import com.mycompany.onlinebankwebserviceapi.service.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author marcin
 */
public class Account {
    
    //account's sort code
    private int sortCode;
    //account's number
    private int accountNumber;
    //account's balance
    private double balance;
    //customer's id that the account belong to
    private String customerLogin;
    


    //the constructor will use the initial deposit to initialize balance
    //the sort code will use the static value from Bank class
    //account number will be incremented number from Bank class
    public Account(double balance, String customerLogin) {
        this.sortCode = CustomerService.BRANCH_CODE;
        this.accountNumber = CustomerService.LAST_ACCOUNT_CREATED+1;
        CustomerService.LAST_ACCOUNT_CREATED = accountNumber;
        this.balance = balance;
        this.customerLogin = customerLogin;
    }

    public Account() {
    }

    
//------------------------------Getters-----------------------------------------    
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getSortCode() {
        return sortCode;
    }

    public String getCustomerId() {
        return customerLogin;
    }
    
//------------------------------Setters-----------------------------------------    
    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
        
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerId(String customerLogin) {
        this.customerLogin = customerLogin;
    }
   
}
