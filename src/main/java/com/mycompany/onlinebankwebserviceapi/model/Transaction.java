package com.mycompany.onlinebankwebserviceapi.model;

import java.time.LocalDate;

/**
 *
 * @author marcin
 */
public class Transaction {
    
    //stores type of a transaction as an enum
    private TransactionType transactionType;
    //stores stransaction date
    private LocalDate date;
    //trnsacation's description
    private String description;
    //post trnsaction balance
    private double postTransactionBalance;
    //reference account buner it belongs to
    private int accountNumber;

    //Constructor
    public Transaction(TransactionType transactionType, String description, 
            double postTransactionBalance, int accountNumber) {
        
        this.transactionType = transactionType;
        //uses the current date for a trnasaction
        this.date = LocalDate.now();
        this.description = description;
        this.postTransactionBalance = postTransactionBalance;
        this.accountNumber = accountNumber;
    }

    public Transaction() {
    }
    
//------------------------------Getters-----------------------------------------    
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
//------------------------------Setters----------------------------------------- 

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPostTransactionBalance(double postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
}
