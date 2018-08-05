package com.mycompany.onlinebankwebserviceapi.resources;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.service.AccountService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author marcin
 */
@Path("/accounts")
public class AccountResource {
    public static AccountService accService = new AccountService();
    String userLogin="";

    public AccountResource() {
//        System.out.println("Constrctucting AddressResources");
    }    
    
    
    public AccountResource(String login) {
//        System.out.println("----"+login+"----constructed AddressResources");
        userLogin=login;
    }    
    
    @GET
    public List<Account> getAccounts() {
        return accService.getAllAccountsForCustomer(userLogin);
    }  
    
    @Path("/all")
    @GET
    public List<Account> getAllAccounts() {
        return accService.getAll();
    } 
    
    @Path("/sortcode")
    @GET
    public String getSortCode() {
        return Account.BRANCH_CODE+"";
    } 
    
    @Path("/total/{login}")
    @GET
    public String getTotalBalanceFromAllAccunts(@PathParam("login") 
            String login) {
           return accService.totalBalanceForUser(login);
    } 
    
    //-----------Return Account with account number provided--------------------
    @Path("/{accNum}")
    @GET
    public Account getAccountDetails(@PathParam("accNum") 
            int accNum) {
        return accService.getAccount(accNum);
    }

    @POST
    @Path("/new")
    public String createAccount(Account a){
        return accService.createAnAccount(a);
    }
    
}
