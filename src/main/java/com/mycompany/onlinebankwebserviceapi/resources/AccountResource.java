package com.mycompany.onlinebankwebserviceapi.resources;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.service.AccountService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//Used to respond to queries made under /accounts url, thos queries are:
//  - list of all accounts in the system
//  - branch sort code
//  - total balance from all accounts for a user
//  - account details for account number
//  - new account creation
/**
 *
 * @authors 
 *          Marcin Krzeminski – X17158851
 *          Carlos Neia – X12116394
 *          Kevin Shannon - X17160324
 *          Joseph McDonnell - X17164761 
 */
@Path("/accounts")
public class AccountResource {
    public static AccountService accService = new AccountService();
    String userLogin="";

//--------------------------Constructors----------------------------------------
    public AccountResource() {

    }    
    
    //used when calling that resource from another resource class
    public AccountResource(String login) {
        userLogin=login;
    }    
    
//----Returns a list of accounts for a given user-------------------------------
//----uses the second constructor to initialize the userlogin-------------------
    @GET
    public List<Account> getAccounts() {
        return accService.getAllAccountsForCustomer(userLogin);
    }  
    
//------Returns all accounts in the system--------------------------------------
    @Path("/all")
    @GET
    public List<Account> getAllAccounts() {
        return accService.getAll();
    } 
    
//------Returns sort code of the branch (constant defined in Account class)-----
    @Path("/sortcode")
    @GET
    public String getSortCode() {
        return Account.BRANCH_CODE+"";
    } 
    
//------Returns total from all accounts for a customer with a login passed in---
    @Path("/total/{login}")
    @GET
    public String getTotalBalanceFromAllAccunts(@PathParam("login") 
            String login) {
           return accService.totalBalanceForUser(login);
    } 
    
//------Return Account with account number provided-----------------------------
    @Path("/{accNum}")
    @GET
    public Account getAccountDetails(@PathParam("accNum") 
            int accNum) {
        return accService.getAccount(accNum);
    }

//-----Creats a new account, Account object is passed in------------------------    
    @POST
    @Path("/new")
    public String createAccount(Account a){
        return accService.createAnAccount(a);
    }
}
