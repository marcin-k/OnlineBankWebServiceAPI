package com.mycompany.onlinebankwebserviceapi.resources;

import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import com.mycompany.onlinebankwebserviceapi.service.AccountService;
import com.mycompany.onlinebankwebserviceapi.service.TransactionService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author marcin
 */
@Path("/transactions")
public class TransactionResource {
    static TransactionService trnsService = new TransactionService();
    int accNumber=0;

    public TransactionResource() {
//        System.out.println("Constrctucting AddressResources");
    }    
    
    public TransactionResource(int accNumber) {
        System.out.println("----"+accNumber+"----constructed TransactionResource");
        this.accNumber=accNumber;
    }    
    
    @GET
    public List<Transaction> getTransactions() {
        return trnsService.getAllTransactionsForAccount(accNumber);
    }
    
    @Path("/all")
    @GET
    public List<Transaction> getAllTransactions() {
        return trnsService.getAll();
    }  
    
    @POST
    @Path("/credit")
    public String credit(Transaction t){
        return trnsService.createCreditTransaction(t);
    }
    
    @POST
    @Path("/debit")
    public String debit(Transaction t){
        return trnsService.createDebitTransaction(t);
    }
    
    //to invoke use localhost:49000/api/transactions/transfer/
    //<ACC NUMBER FROM>/<ACC NUMBER TO>/<AMOUNT>
    @GET
    @Path("/transfer/{accFrom}/{accTo}/{amount}/")
    public String transfer(@PathParam("accFrom") int accFrom,@PathParam("accTo") 
            int accTo, @PathParam("amount") double amount ){
        
        return trnsService.transferMoney(accFrom, accTo, amount);
    }
    
}