package com.mycompany.onlinebankwebserviceapi.resources;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.service.AccountService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author marcin
 */
@Path("/")
public class AccountResource {
    static AccountService accService = new AccountService();
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

    
}
