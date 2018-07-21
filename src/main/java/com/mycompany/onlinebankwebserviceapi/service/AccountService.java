package com.mycompany.onlinebankwebserviceapi.service;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcin
 */
public class AccountService {
    public static List<Account> listAcc = new ArrayList<>();
    public static boolean init = true;
    
//-------------------------------Init-------------------------------------------    
    public AccountService () {
        System.out.print("constructing address service");
        if (init) {
            Account a1 = new Account(1200.00, "bob1");
            Account a2 = new Account(1500.00, "bob2");
       
            listAcc.add(a1);
            listAcc.add(a2);
            init = false;
        }
    }
    
//-----------Return all accounts for a customer with passed in login------------        
    public List<Account> getAllAccountsForCustomer(String login) {
        List<Account> tempList = new ArrayList<>();
        for(Account ad: listAcc){
            if(ad.getCustomerId().equalsIgnoreCase(login)){
                tempList.add(ad);
            }                
        }
        return tempList;
    }
//-----------Return all accounts for a customer with passed in login------------        
    public List<Account> getAll() {
        return listAcc;
    }
}
