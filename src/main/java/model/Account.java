package model;

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
    //transacrtion history
    private ArrayList<Transaction> transactions;

    //the constructor will use the initial deposit to initialize balance
    //the sort code will use the static value from Bank class
    //account number will be incremented number from Bank class
    public Account(double balance) {
        this.sortCode = Bank.BRANCH_CODE;
        this.accountNumber = Bank.LAST_ACCOUNT_CREATED+1;
        Bank.LAST_ACCOUNT_CREATED = accountNumber;
        this.balance = balance;
        transactions = new ArrayList<Transaction>();
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
   
}
