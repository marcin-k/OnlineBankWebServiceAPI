package com.mycompany.onlinebankwebserviceapi.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import com.mycompany.onlinebankwebserviceapi.model.Customer;
import com.mycompany.onlinebankwebserviceapi.service.CustomerService;
//Used to respond to queries made under /customer url, thos queries are: 
//  - creates a customer
//  - gets list of all customer
//  - gets specific customer's details
//  - validates username and password for a customer
//  - gets list of accounts for a customer
//  - gets all transactions for a specific account
/**
 *
 * @authors 
 *          Marcin Krzeminski – X17158851
 *          Carlos Neia – X12116394
 *          Kevin Shannon - X17160324
 *          Joseph McDonnell - X17164761 
 */
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    //variable reference to CustomerService instance 
    public static CustomerService customerService = new CustomerService();

//-------------------------Creates a new customer-------------------------------
    //creates a new cusomter 
    //to add from windows cmd:
    //curl -X POST -H "Content-Type:application/json" -d "{\"name\": \"NAME\",
    // \"address\": \"ADDRESS\",\"email\": \"EMAIL\",
    // \"login\": \"LOGIN\",\"password\": \"PASSWORD\"}" 
    // http://localhost:49000/api/customers
    @POST
    public String createCustomer(Customer u) {       
        return customerService.createUser(u);
    }
        
//----------------------Return all customers------------------------------------
    @GET
    public List<Customer> getUsers() {
        return customerService.getAllUsers();
    }   
//-----------------Return customer with a passed in login-----------------------
    @GET
    @Path("/{userLogin}")
    public Customer getUser(@PathParam("userLogin") String login) {
        return customerService.getUserByLogin(login);
    }
//-----------------Validates customer's username and password-------------------
    @GET
    @Path("/{userLogin}/{userPassword}")
    public String login(@PathParam("userLogin") String login,@PathParam
        ("userPassword") String pass) {
        return customerService.login(login, pass);
    }
//-----------Return all accounts for a customer with passed in login------------   
    @Path("/{userLogin}/accounts")
    public AccountResource getAccountsResources(@PathParam("userLogin") 
            String userLog) {
        return new AccountResource(userLog);
    }
    
//-----------Return all transactions for an account number----------------------   
    @Path("/{userLogin}/accounts/{accNum}/transactions")
    public TransactionResource getTransactionResources(@PathParam("accNum") 
            int accNum) {
        return new TransactionResource(accNum);
    }
}
