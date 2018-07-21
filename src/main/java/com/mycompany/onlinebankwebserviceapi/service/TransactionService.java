package com.mycompany.onlinebankwebserviceapi.service;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import com.mycompany.onlinebankwebserviceapi.resources.AccountResource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcin
 */
public class TransactionService {
    public static List<Transaction> transactionList = new ArrayList<>();
    public static boolean initThis = true;
    
//-------------------------------Init-------------------------------------------    
    public TransactionService () {
        System.out.print("constructing address service");
        if (initThis) {
            createCreditTransaction(new Transaction("test1", 100000001, 200.00));
            createCreditTransaction(new Transaction("test1", 100000001, 500.00));
            createCreditTransaction(new Transaction("test1", 100000002, 500.00));
            initThis = false;
        }
    }
    
//-----------Return all transactions for an account ----------------------------        
    public List<Transaction> getAllTransactionsForAccount(int accNumber) {
        List<Transaction> tempList = new ArrayList<>();
        for(Transaction t: transactionList){
            if(t.getAccountNumber()==accNumber){
                tempList.add(t);
            }
        }  
        return tempList;
    }
    
//-----------------Credit transaction ------------------------------------------
    //transaction type should be 0 for debit or 1 for credit, 
    //to invoke use:
    //curl -X POST -H "Content-Type:application/json" -d "{\"description\": 
    //\"test2\",\"accountNumber\": \"100000001\",\"amount\": \"200\"}" 
    //http://localhost:49000/api/transactions/credit
    public String createCreditTransaction(Transaction t){
        t.setTransactionType(1);
        for(Account a :AccountResource.accService.getAll()){
            if(t.getAccountNumber()==a.getAccountNumber()){
                double amount = a.getBalance()+t.getAmount();
                a.setBalance(amount);
                t.setPostTransactionBalance(amount);
                transactionList.add(t);
                return "Credit operation completed";
            }
        }    
        return "Account number incorrect";
    }

//-----------------Debit transaction -------------------------------------------    
    //transaction type should be 0 for debit or 1 for credit, 
    //to invoke use:
    //curl -X POST -H "Content-Type:application/json" -d "{\"description\": 
    //\"test2\",\"accountNumber\": \"100000001\",\"amount\": \"200\"}" 
    //http://localhost:49000/api/transactions/debit
    public String createDebitTransaction(Transaction t){
        t.setTransactionType(-1);
        for(Account a :AccountResource.accService.getAll()){
            if(t.getAccountNumber()==a.getAccountNumber()){
                if(t.getAmount()>a.getBalance()){
                    return "Not sufficient balance to perform "
                            + "this operation";
                }
                else{
                    double amount = a.getBalance()-t.getAmount();
                    a.setBalance(amount);
                    t.setPostTransactionBalance(amount);
                    transactionList.add(t);
                    return "Debit operation completed";
                }
            }
        }    
        return "Account number incorrect";
    }
    
//-------------Transfers funds from one account to another ---------------------
    public String transferMoney(int accountFrom, int accountTo, double amount){
        //check if both exist
        
        //check if from has sufcient funding
        
        
        
        return "";
    }
}