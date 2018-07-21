package com.mycompany.onlinebankwebserviceapi.service;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import com.mycompany.onlinebankwebserviceapi.model.TransactionType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcin
 */
public class TransactionService {
    public static List<Transaction> list = new ArrayList<>();
    public static boolean init = true;
    
//-------------------------------Init-------------------------------------------    
    public TransactionService () {
        System.out.print("constructing address service");
        if (init) {
           
            Transaction a1 = new Transaction(TransactionType.DEBIT, 
                    "first transaction", 2000.00, 100000001);
            Transaction a2 = new Transaction(TransactionType.DEBIT,
                    "second transaction", 1400.00, 100000001);
       
            list.add(a1);
            list.add(a2);
            init = false;
        }
    }
    
//-----------Return all transactions for an account ----------------------------        
    public List<Transaction> getAllTransactionsForAccount(int accNumber) {
        List<Transaction> tempList = new ArrayList<>();
        for(Transaction t: list){
            if(t.getAccountNumber()==accNumber){
                tempList.add(t);
            }
        }  
        return tempList;
    }
}