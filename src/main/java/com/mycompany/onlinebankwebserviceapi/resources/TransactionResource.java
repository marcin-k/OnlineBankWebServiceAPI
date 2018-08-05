package com.mycompany.onlinebankwebserviceapi.resources;

import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import com.mycompany.onlinebankwebserviceapi.service.TransactionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//Used to respond to queries made under /transactions url, thos queries are: 
//  - returns all trnsactions for a specific account
//  - returns all transactions in the system 
//  - creates a new credit trnsaction
//  - creates a new debit transation
//  - makes a transfer of funds from one account to another
/**
 *
 * @authors 
 *          Marcin Krzeminski – X17158851
 *          Carlos Neia – X12116394
 *          Kevin Shannon - X17160324
 *          Joseph McDonnell - X17164761 
 */
@Path("/transactions")
public class TransactionResource {
    
    //reference variable for TransactionService instance
    static TransactionService trnsService = new TransactionService();
    //account number used when accesing this class from another resource class
    int accNumber=0;

//-----------------------Constructors-------------------------------------------
    public TransactionResource() {
    }    
    
    public TransactionResource(int accNumber) {
        this.accNumber=accNumber;
    }    
    
//-------Get all transactions for a specific account based on account number----
//-------passed into constructor------------------------------------------------    
    @GET
    public List<Transaction> getTransactions() {
        return trnsService.getAllTransactionsForAccount(accNumber);
    }

//------Returns all transactions in the system----------------------------------    
    @Path("/all")
    @GET
    public List<Transaction> getAllTransactions() {
        return trnsService.getAll();
    }  
   
//-----Creates a new credit transaction-----------------------------------------    
    @POST
    @Path("/credit")
    public String credit(Transaction t){
        return trnsService.createCreditTransaction(t);
    }

//-----Creates a new debit transaction------------------------------------------    
    @POST
    @Path("/debit")
    public String debit(Transaction t){
        return trnsService.createDebitTransaction(t);
    }
    
//-----Transfers a funds from one account to another----------------------------    
    //to invoke use localhost:49000/api/transactions/transfer/
    //<ACC NUMBER FROM>/<ACC NUMBER TO>/<AMOUNT>
    @GET
    @Path("/transfer/{accFrom}/{accTo}/{amount}/")
    public String transfer(@PathParam("accFrom") int accFrom,@PathParam("accTo") 
            int accTo, @PathParam("amount") double amount ){
        
        return trnsService.transferMoney(accFrom, accTo, amount);
    }
    
}