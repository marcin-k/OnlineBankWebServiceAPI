package com.mycompany.onlinebankwebserviceapi.service;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import static com.mycompany.onlinebankwebserviceapi.model.Account.LAST_ACCOUNT_CREATED;
import com.mycompany.onlinebankwebserviceapi.model.Customer;
import com.mycompany.onlinebankwebserviceapi.resources.CustomerResource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//This class is used to accomodate requestes made in AccountResource class
//Class creates a two example accounts 
/**
 *
 * @authors 
 *          Marcin Krzeminski – X17158851
 *          Carlos Neia – X12116394
 *          Kevin Shannon - X17160324
 *          Joseph McDonnell - X17164761 
 */
public class AccountService {
    
    //formatter to return the double with only 2 decimal places
    private static DecimalFormat df2 = new DecimalFormat(".##");
    //stores all accounts in the system
    public static List<Account> listAcc = new ArrayList<>();
    //used to initialize the constructor to load few example records into
    //the system
    public static boolean init = true;
    
//---------Initialisation Constructor-------------------------------------------    
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
 //-----------Return account for with a number provided-------------------------
    public Account getAccount(int accNumber) {
        Account acc = new Account();
        for(Account ad: listAcc){
            if(ad.getAccountNumber()==accNumber){
                acc = ad;
            }                
        }
        return acc;
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
    
//-----------Creates a new account for a customer-------------------------------        
    //to invoke use:
    //curl -X POST -H "Content-Type:application/json" -d 
    //"{\"balance\": \"220.0\",\"customerId\": \"bob1\"}" http://localhost:49000/api/accounts/new
    public String createAnAccount(Account a) {
        //checks if the customer with id exist
        for(Customer c :CustomerResource.customerService.getAllUsers()){
            if(c.getLogin().equalsIgnoreCase(a.getCustomerId())){
                a.setAccountNumber(Account.LAST_ACCOUNT_CREATED+1);
                Account.LAST_ACCOUNT_CREATED = LAST_ACCOUNT_CREATED+1;
                a.setSortCode(Account.BRANCH_CODE);
                listAcc.add(a);
                return "Account has been created.";
            }
        }    
        return "Account was not created, user id incorrect";
    }
    
//-------Returns total from all accounts for a customer-------------------------    
    public String totalBalanceForUser(String login){
        double total = 0;
        for(Account a: getAll()){
            if(a.getCustomerId().equalsIgnoreCase(login)){
                total+=a.getBalance();
            }
        }
        return df2.format(total)+"";
    }
}
